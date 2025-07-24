package com.khahnm04.coffee.controller.web;

import com.khahnm04.coffee.entity.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @Controller: 1 bean -> dc tự new từ đầu bởi IoC, bởi Container, chuyên trả lời các http request đến từ url của trình duyệt của user
 * Có nhiều url khác nhau, thì ứng với nhiều hàm trong class này
 * Các hàm trả về html, trang web lung linh
 */
@Controller
public class CoffeeWebController {

    @GetMapping("/") // user gõ localhost:6969/ nghĩa là nhảy đến hàm này
    public String home(Model model) {
        model.addAttribute("cup1", "value_coffee");
        model.addAttribute("cup2", new Coffee("JC", "Cafe Java nee", 29_000));
        return "index"; // Trả về tên trang cho trình duyệt
    }

}
