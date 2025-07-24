package com.khahnm04.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication = @Configuration + @ComponentScan() Scan ngay những class trong com.khahnm04.coffee mà có chứa @Component, @Service, @Repository, @RestController, @Controller new những đứa này, tiêm/chích chúng vào những class tương ứng...
// @EnableAutoConfiguration: tự new, tự cấu hình: JPA/Hibernate, Tomcat, MVC,...
@SpringBootApplication
public class JavaCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCoffeeApplication.class, args);
    }

    //@Bean ở đây để chủ động new riêng những dependency, new xong gửi cho IoC Container quản lí giúp

}
