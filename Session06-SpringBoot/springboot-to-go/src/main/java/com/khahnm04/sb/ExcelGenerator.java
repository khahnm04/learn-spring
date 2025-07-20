package com.khahnm04.sb;

import org.springframework.stereotype.Component;

//@Component
public class ExcelGenerator {

    public void generateFile(String fileName) {
        System.out.println("Spring Boot: the " + fileName+ ".xlsx has been generated successfully!");
    }

}
