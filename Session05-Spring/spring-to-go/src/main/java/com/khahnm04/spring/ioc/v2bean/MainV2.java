package com.khahnm04.spring.ioc.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        PdfGenerator pdfGenerator1 = (PdfGenerator) context.getBean("pdfGenerator");
//        pdfGenerator1.generatorFile("20:13");
//
//        PdfGenerator pdfGenerator2 = context.getBean("pdfGenerator", PdfGenerator.class);
//        pdfGenerator2.generatorFile("20:19");

        PdfGenerator pdfGenerator3 = context.getBean(PdfGenerator.class);
        pdfGenerator3.generatorFile("20:20");

        PdfGenerator pdfGenerator4 = context.getBean("minhKhanh", PdfGenerator.class);
        pdfGenerator4.generatorFile("20:22");
    }

}
