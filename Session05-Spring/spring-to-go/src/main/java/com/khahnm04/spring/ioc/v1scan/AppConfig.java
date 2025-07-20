package com.khahnm04.spring.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Class này là nơi ta khai báo các object dependency của riêng ta và ta gửi cho spring container nó giữ
 * Cũng là nơi khai báo các thông tin về các dependency khác mà ta ko tự tạo, IoC hẳn cho cho spring lo giùm
 * Tóm lại: Class này là nơi lưu giữ các thông tin về các dependency mà ta nhờ spring quản lý giúp
 * Các object dependency new PdfGenerator(), new ContractService(), new Repository() sẽ dc khai báo, và dc quản lý ở class này và sau đó chuyển giao cho spring
 * những object dependenncy kể từ nay về sau gọi là các bean - hạt đậu thần
 */

/*
 * @Configuration là một annotation (chú thích) của Spring, dùng để đánh dấu một class là class cấu hình, tức là nơi khai báo các bean cho container.
 * Vai trò chính của @Configuration: Nó báo cho Spring biết rằng: "Class này chứa các cấu hình để tạo ra các bean, hãy xử lý nó như 1 file cấu hình."
 * @Configuration = @SpringBootApplication (khi chơi vơi spring boot)
 * Nơi tụ họp thông tin về các bean/object dependency cần phải dc new
 * ----------
 * @ComponentScan("com.khahnm04.spring.ioc.v1scan"): Scan tất cả cái package này, coi class nào có @Component, @Service, @Repository, @Controller, @RestController,... thì new chúng nó và gọi chúng là bean
 * @ComponentScan(basePackages = {"com.khahnm04.spring.ioc.v1scan","com.khahnm04.spring.ioc.noioc"}): nếu muốn Scan nhiều package khác nữa
 */
@Configuration
@ComponentScan("com.khahnm04.spring.ioc.v1scan")
public class AppConfig {

}
