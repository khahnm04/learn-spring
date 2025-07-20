package com.khahnm04.spring.noioc;

public class PdfGenerator {

    // CLass này chuyên lo việc generate ra pdf -> thỏa SRP trong SOLID
    // làm giả cái hàm generateFile() ko làm thật vì tốn time, ngoài spoce
    // giả nhưng vẫn chạy dc, gọi là Mock
    public void generatorFile(String fileName) {
        // todo: logic xử lý gen ra file pdf
        System.out.println("The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }

}
