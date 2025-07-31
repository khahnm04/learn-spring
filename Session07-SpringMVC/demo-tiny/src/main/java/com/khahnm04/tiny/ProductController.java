package com.khahnm04.tiny;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/products/edit")
    public String edit() {
        return "product-form";
    }

    @GetMapping("/products/new")
    public String create() {
        return "product-form";
    }

    @GetMapping("/products")
    public String showProducts(@RequestParam(name = "keyword", required = false) String kw, Model model, HttpSession session) {
        // chặn gõ url
        Integer role = (Integer) session.getAttribute("role");
        if (role == null) {
            return "redirect:/login";
        }
        if (kw != null && !kw.isEmpty()) {
            model.addAttribute("result", kw + " Đã where rồi - Done");
        } else {
            // đi qua login -> show full
            model.addAttribute("result", "Bản full ko che");
        }
        model.addAttribute("role", session.getAttribute("role"));
        return "products";
    }

}
