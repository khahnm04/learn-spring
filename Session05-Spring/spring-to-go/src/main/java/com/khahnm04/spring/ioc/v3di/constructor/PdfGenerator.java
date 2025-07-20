package com.khahnm04.spring.ioc.v3di.constructor;

import org.springframework.stereotype.Component;

@Component // tự new vì ko trạng thái (ko trạng thái: ko có field như tên, tuổi, địa chỉ, dob...)
public class PdfGenerator {

    public void generatorFile(String fileName) {
        // todo: logic xử lý gen ra file pdf
        System.out.println("V3 DI IoC -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }

}
