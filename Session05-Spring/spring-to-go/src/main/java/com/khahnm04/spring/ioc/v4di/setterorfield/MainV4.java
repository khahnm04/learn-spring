package com.khahnm04.spring.ioc.v4di.setterorfield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV4 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ContractService contractService = context.getBean(ContractService.class);
        contractService.processCntract();

        ContractService contractService2 = context.getBean("minhKhanh", ContractService.class);
        contractService2.processCntract();
    }

}
