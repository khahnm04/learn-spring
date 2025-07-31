package com.khahnm04.coffee.controller;

import com.khahnm04.coffee.entity.Category;
import com.khahnm04.coffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/*
 * Class này lo các xử lý liên quan đến sản phẩm - product (CRUD), xử lý request/response, phụ trách các url dính dáng đến CRUD product, sau đó chuyển dần cho service, repository
 * nó lắng nghe các url, và xem url nào phù hợp với hàm trong class này thì gọi hàm đó - method mapping với url
 * 2 việc: lắng nghe url, nghe xong, gọi đúng hàm ứng với url
 * việc 0: nó phải là 1 bean dc new tự động, vào RAM và nghe
 * Việc 1: Nghe - class này phải là @Controller: Bean và lắng nghe
 * việc 2: hàm nào ứng với url nào -> trả về html
 * Important: 1 url GET -> ứng với 1 hàm "Return tên trang (html) nào đó" nào đó, hàm phải nằm trong 1 class @Controller, GET có nghĩa là muốn lại 1 trang thông tin
 */
@Controller // @RestController: cũng lắng nghe, nhưng trả về Json
public class ProductController {

    /*
     * list nghĩa là show danh sách sản phẩm nằm trong trang products.html
     * @RequestMapping("/products") ->
     * nguy hiểm 1 chút: url này dành cho cả GET/POST/PUT/ ... miễn match url
     * ta cần phân tách: hàm nào dành cho GET, hàm nào dành cho POST
     * CÁCH VIẾT CHUẨN, PHAN BIET HÀM NÀO DÀNH CHO GET/POST ... -> DÀI
     * @RequestMapping(path={"/products", "/jack"}, method = RequestMethod.GET) // url map với hàm này: localhost:6969/product or localhost:6969/jack
     * Cách viết ngắn gọn hơn -> hàm nhận request thuộc nhóm GET
     * @GetMapping(path = {"/products", "/jack"}) // Có bao nhiêu url map tới hàm này
     */
    @GetMapping("/products")
    public String list(Model model) {
        // gửi đồ cho view
        model.addAttribute("msg", "Xin chao ADMINN");
        // Chuẩn bị 1 danh sách sản phẩm để show ra trang web products.html (hard-code - thực tế gọi service, repo)
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("CF1", "Cà phê Java nguyên bản  1", 10_000));
        productList.add(new Product("CF2", "Cà phê Java nguyên bản  2", 20_000));
        productList.add(new Product("CF3", "Cà phê Java nguyên bản  3", 30_000));
        // Gửi danh sách sản phẩm trong thùng đồ, lấy lại đồ qua key products
        model.addAttribute("products", productList);
        return "products"; // return tên trang - view (ko cần .html vì tự thymeleaf dependency nó lo gắn thêm)
    }

    /*
     * @GetMapping(path = {"/products/edit/CF1", "/products/edit/CF2", "/products/edit/CF3"})
     * tách url thành 2 phần: 1 phần cố định và 1 phần thay đổi - phần thay đổi gọi là path variable
     * return "product-form"; -> .html mà ko cần ghi ra
     * Lệnh return trang luôn đính kèm theo 1 thùng giao hàng, gửi đồ
     * Theo style "key"-value, chia khoá, mảnh giấy để lấy món đồ trong thùng. Thymeteaf engine dùng chia khoá để mò vào thùng lấy đồ ra mix trộn thành HTML thuần và trả về cho TOMCAT -> BROWSER !!!
     */
    @GetMapping("/products/edit/{product_id}")
    public String showProductForm(Model model, @PathVariable("product_id") String id) {
        // đã trích dc id muốn xem chi tiết từ click hyperlink của user
        // todo: dùng service gọi repo để where trong table product ra sản phẩm có id vừa click (làm sau)
        Product selectedProduct = null;
        if (id.equalsIgnoreCase("CF1")) {
            selectedProduct = new Product("CF1", "Cà phê Java nguyên bản  1", 10_000);
        } else if (id.equalsIgnoreCase("CF2")) {
            selectedProduct = new Product("CF2", "Cà phê Java nguyên bản  2", 20_000);
        } else if (id.equalsIgnoreCase("CF3")) {
            selectedProduct = new Product("CF3", "Cà phê Java nguyên bản  3", 30_000);
        }
        // ném đồ vào thùng  cho trang render
        model.addAttribute("khanh", selectedProduct);
        // Gửi thêm DS cates
        model.addAttribute("cates", getCategories());
        return "product-form";
    }

    /*
     * hàm update 1 sản phẩm xuống db, dc gọi bởi việc nhấn nút [save] -> Nhận vào các data gõ trong ô nhập dc gửi lên đây
     * @RequestParam: gửi từng ô nhập ở form lên server, map vào biến trong hàm, tên biến hứng trong hàm ko cần giống biến trong form,
     * nhưng @RequestParam("tên-biến-dưới-form-html-ứng-với-thuộc-tính-name-của-ô-nhập")
     * Với hàm post (bản chất vẫn là get- nhưng gửi nhiều data khi get
     * Khi hàm post trả về 1 trang kết quả qua lệnh return "tên trang" thì url post vẫn giữ nguyên, trong khi đó thân trình duyệt sẽ có data sẽ trả về
     * Với post F5 -> trả về KQ, nhưng lại gửi kèm lại đống data ->Resubmitsion form (giống như nhấn lại nút bấm - vì nhấn nút gọi url này) ->Nguy hiểm với tính năng create, F5 màn hình KQ sẽ tương đương việc gửi lại data, chạy lại xử lý -> duplicate data
     * Với post ta cần đổi url, tránh submit lại khi F5 (url post xử lý xong, return trang và đổi url -> redirect method - định hướng lại url, gọi lại 1 url mới nhưng vẫn cùng KQ trả về)
     * =>>> IMPORTANT: xử lý post xong đổi url KQ để tránh F5 lại url post (đổi url và F5 và F5 KQ, ko phải F5 post)
     * với get F5 -> trả về KQ
     * hiện tượng get y chan: url vẫn giữ nguyên, trong khi đó thân trình duyệt có data dc trả về - trang trả về
     * Ý nghĩa việc giữ nguyên url: gọi hàm trả về kết qủa ở dưới, tên hàm vẫn ở trên
     */
    @PostMapping("/products/save")
    public String update(@ModelAttribute("khanh") Product prod, Model model, RedirectAttributes redirectAtts) {
        // 2 lệnh model.addAttribute() vô dụng nếu chơi redirect (vì redirect dùng model khác)
        model.addAttribute("msg", "Đã update thành công - Mock Message");
        model.addAttribute("pname", prod.getName());
        // Gửi ké sang model của hàm /msg
        redirectAtts.addFlashAttribute("formMsg", "Đã update/create thành công - Mock Message");
        redirectAtts.addFlashAttribute("pname", prod.getName());
        //return "result"; // -> Resubmitsion xuất hiện
        return "redirect:/products"; // Gọi url: localhost:6969/products
    }

    /*
     * Làm sao để lấy name của bên post (1 url, 1 hàm tương ứng, 1 thùng model mới để bỏ đồ vào trc khi render)
     * Kỹ thuật chuyển data từ model kia sang model này ở câu lệnh redirect (vì redirect là gọi url mới -> chơi thùng mới
     * Trước khi redirect gửi ké thêm data từ model cũ sang model mới (từ model của post ké sang model get này)
     * Model ở đây, ngoài data có chính chủ hàm này, còn nhận thêm từ bên post gửi sang
     */
    @GetMapping("/msg")
    public String showMessage(Model model) {

        return "result";
    }

    /*
     * chuẩn bị danh sách category -> trả về trang product-form để show DS chọn loại SP
     * Code chuẩn: phải ở bên categoryService/categoryRepo
     * hard-code danh sách
     */
    public List<Category> getCategories() {
        return List.of(
                new Category(100L, "Trà sữa", "..."),
                new Category(200L, "Cà phê", "..."),
                new Category(300L, "Beer-nước ngọt", "..."),
                new Category(400L, "Bánh kẹo", "...")
        );
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("khanh", new Product());
        model.addAttribute("cates", getCategories());
        return "product-form";
    }

}

/*
 * khi controller tìm thấy hàm xử lí url tương ứng, nó sẽ gọi hàm này
 * nhưng trước khi gọi, nó gửi cho hàm 1 thùng chứa đồ rỗng gọi là model
 * mình nhét data vào thùng chứa đồ này, thùng đồ dc new tự động và dc chích vào hàm xử lí url
 * khi thực thi lệnh return cho url get... thì spring nó sẽ đính kèm cái thùng đồ vào cùng trang trả về, và đưa tên trang + thùng đồ cho thymeleaf mix, trộn, render
 * thymeleaf sẽ lấy đồ trong thùng, trộn với các tag html, trộn xong, trả cho tomcat trang web html ngon -> đẩy về trình duyệt user!!!
 * câu hỏi: làm sao nhét đồ - data vào thùng (thùng chứa sc nhiều đồ), và lấy ra (controller là nhét đồ vào thùng, html/thymeleaf là lấy đồ ra khỏi thùng và mix)
 */
/*
 * hãy tưởng tượng tủ gửi đồ, quầy gửi túi/giỏ ở siêu thị và tttm, bỏ đồ vào hộc tủ, lấy chìa khoá, mảnh giấy, chìa khoá, mảnh giấy gọi là key | món đồ gọi là value!!!!!!!!
 * có chìa, mảnh giấy thì lấy được value/món đồ!!!
 * gửi đồ vào thùng (trong controller)
 * model.addattribute(key, value) ~ (tên-biến, value) ~ (chuỗi không trùng, object bất kì bạn muốn cất)
 * bên view lấy đồ, dùng key: ${tên-key} -> trả về Object, món đồ
 */
