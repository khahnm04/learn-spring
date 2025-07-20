package com.khahnm04.spring.ioc.v3di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // đang có 2 bean: Service và Generator
        ContractService contractService = context.getBean(ContractService.class);

        contractService.processContract();

    }

}
