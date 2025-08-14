package com.khahnm04.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Class này là class trung tâm, nơi chứa những khai báo về các loại bean có trong app này: bean là những Object dependency dc IoC Container tự new, hay tự mình new và gửi cho Container giữ giúp
 * Dependency Object là những class có @Component, @Service, @Repository, @Controller, @RestController
 * @SpringBootApplication gộp sẵn 3 annotation khác: @Configuration; @ComponentScan, @EnableAutoConfiguration (khởi động Tomcat, JPA/Hibernate, MVC - điều khiển request/response)
 */
@SpringBootApplication
public class DemoCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCoffeeApplication.class, args);
    }

}
