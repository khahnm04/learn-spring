package com.khahnm04.tiny;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping({"/", "/login"}) // localhost:6969/ or localhost:6969/login
    public String showLogin() {
        return "login";
    }

    @PostMapping( "/do-login")
    public String doLogin(@RequestParam("username") String username, HttpSession session) {
        // todo: session là 1 cái thùng dành cho từng user khác nhau, chứa nhiều món đồ, dùng chung cho các page -> f5 của mỗi page, vùng session ko mất (thông tin login, role cất ở đây)
        if (username.equalsIgnoreCase("admin")) {
            session.setAttribute("role", 1);
        } else {
            session.setAttribute("role", 2);
        }
        return "redirect:/products"; // Bắt trình duyệt gọi lại url mới ứng với trang trả về
        // return "products";
    }

//    @PostMapping( "/do-login")
//    public String doLogin(@RequestParam("username") String username, Model model, RedirectAttributes redirectAttrs) {
//        // todo: lấy từ db
//        if (username.equalsIgnoreCase("admin")) {
//            //model.addAttribute("role", 1);
//            redirectAttrs.addFlashAttribute("role", 1);
//        } else {
//            //model.addAttribute("role", 2);
//            redirectAttrs.addFlashAttribute("role", 2);
//        }
//        return "redirect:/products"; // Bắt trình duyệt gọi lại url mới ứng với trang trả về
//        // return "products";
//    }

}

/*
 * Http: giao thức theo style Stateless, ko nhớ nhau lâu
 * Request/Response xong, quên luôn ai đã gọi
 * Cần có kĩ thuật để lưu lại dấu vết của 1 user: Request lần trước, lần này là của cùng 1 người
 * VD: setting ngôn ngữ của web app dùng chung cho nhiều trang
 */
