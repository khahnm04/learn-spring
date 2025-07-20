package com.khahnm04.spring.ioc.v2bean;

import org.springframework.stereotype.Component;

//@Component // để mày dc tự new bởi Spring IoC container
public class PdfGenerator {

    public void generatorFile(String fileName) {
        // todo: logic xử lý gen ra file pdf
        System.out.println("V2 -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }

}
