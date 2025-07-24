package com.khahnm04.coffee.controller.api;

import com.khahnm04.coffee.entity.Coffee;
import org.springframework.web.bind.annotation.*;

/*
 * @RestController: Phục vụ các url mà muốn lấy data thô, trả về json, hoặc nhận json từ trang web gửi lên
 * Thường bạn thấy url api tách hẳn so với url web
 * ví dụ: https: .../api/v1/??? hoặc .../api/v2/???
 */
@RestController
@RequestMapping("/api/v1")
public class CoffeeApiController {

    /*
     * Gọi Jackson để convert từ Object -> Json bên trình duyệt
     * data thô - Web API: gọi hàm qua url trả về Json
     * Swagger UI: help, document chứa url để dùng thử API
     */
    @GetMapping("/cup") //localhost:6969/api/v1/cup
    public Coffee getACup() {
        // Lấy từ DB lên qua Service -> Repository -> JPA/Hibernate -> JDBC -> Table
        return new Coffee("JC_API", "Cafe Java test API", 29_000);
    }

    /*
     * Gửi data dạng Json lên server
     * @RequestBody: dùng để hứng data JSON từ client gửi lên body của HTTP request.
     *     [Client gửi JSON]
                |
                V
        [Spring Boot Controller]
        @RequestBody Coffee cup
                |
                V
        [Java Object 'Coffee']
     */
    @PostMapping("/add") //localhost:6969/api/v1/add
    public Coffee addACup(@RequestBody Coffee cup) {
        // sửa object đã nhận, xong tra về để mn biết mình đã nhận từ client, và mình chỉnh ít inf
        String oldName = cup.getName();
        String newName = oldName + " | Post neee!!!";
        cup.setName(newName);
        return cup;
    }

}
