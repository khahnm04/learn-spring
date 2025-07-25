package com.khahnm04.coffee.controller;

import com.khahnm04.coffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // list nghĩa là show danh sách sản phẩm nằm trong trang products.html
    @RequestMapping("/products") // url map với hàm này: localhost:6969/product
    public String list(Model model) { // Khi controller tìm thấy hàm xử
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
