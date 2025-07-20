package com.khahnm04.spring.ioc.v4di.setterorfield;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {

    public void generatorFile(String fileName) {
        // todo: logic xử lý gen ra file pdf
        System.out.println("V4 DI IoC (SETTER & FIELD) -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }

}
