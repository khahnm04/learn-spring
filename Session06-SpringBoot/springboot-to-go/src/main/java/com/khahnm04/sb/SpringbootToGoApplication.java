package com.khahnm04.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // Mang nhiều ý nghĩa
// gộp bên trong gồm @Configuration và @ComponentScan(...),...
// Class này chính là AppConfig bên phiên bản pure Spring vừa làm
public class SpringbootToGoApplication {

    public static void main(String[] args) {
        // Tạo ra context, tạo ra IoC Container chứa các @bean -> Câu lệnh này xong là các bean đã xong
        ApplicationContext ctx = SpringApplication.run(SpringbootToGoApplication.class, args);

        // dc quyền xài bean sau lệnh này, quay trở lại bài Spring vừa rồi
        ExcelGenerator excelGenerator = (ExcelGenerator) ctx.getBean("minhKhanh");
        excelGenerator.generateFile("20250615_10:39:79");

    }

    // Tạo @Bean chỗ này
    @Bean("minhKhanh")
    public ExcelGenerator excelGenerator() {
        return new ExcelGenerator();
    }

}
