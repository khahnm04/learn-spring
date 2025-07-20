package com.khahnm04.spring.ioc.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV1 {

    public static void main(String[] args) {

        /*
         * Khởi tạo container, thùng chứa object, thùng chứa bean, (Vào Spring rồi đó em)
         * ApplicationContext context chính là: 🧰 "Một cái thùng chứa tất cả các bean đã được Spring new sẵn và quản lý vòng đời"
         * context thuộc class ApplicationContext là TRÙM CUỐI quản lý các Object - bean, quản lí luôn việc tiêm vào các object khác
         * ĐỨA NÀO MUỐN ĐƯỢC TIÊM VÀO, ĐỨA ĐÓ CX PHẢI LÀ BEAN
         * TRÙM CUỐI CONTEXT - CHOI TRONG RAM
         * TRÙM CUỐI NÀY GIONG ENTITY-MANAGER-FACTORY DÃ HỌC - CHƠI DB
         * Mặc định đặt tên các bean theo tên class và giật xuống kiểu con lạc đà (camelCase)
         * ----- Luồng chạy: -----
         * Khi bạn chạy: ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         * Thì Spring:
         * 1. Chạy vào class AppConfig, Quét package theo @ComponentScan
         * 2. Tìm các class có @Component, @Service, @Repository, @Controller,...
         * 3. new những class này
         * 4. Gán chúng vào cái "thùng chứa" - chính là context
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy bean ra xài
        PdfGenerator pdfGenerator1 = (PdfGenerator) context.getBean("pdfGenerator");
        pdfGenerator1.generatorFile("1944");

        PdfGenerator pdfGenerator2 = context.getBean("pdfGenerator",PdfGenerator.class);
        pdfGenerator1.generatorFile("1954");

        PdfGenerator pdfGenerator3 = context.getBean(PdfGenerator.class);
        pdfGenerator3.generatorFile("1956");

    }

}
