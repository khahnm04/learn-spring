package com.khahnm04.spring.ioc.v1scan;

import org.springframework.stereotype.Component;

/*
 * @Component nghĩa là: đây là 1 object, 1 bean, sẽ dc tự động new bởi thư viện spring, spring context (dc quản lý bởi spring)
 * @Service, @Repository cx dc luôn, 2 th này là con của @Component
 */
@Component
public class PdfGenerator {

    public void generatorFile(String fileName) {
        // todo: logic xử lý gen ra file pdf
        System.out.println("V1 -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }

}
