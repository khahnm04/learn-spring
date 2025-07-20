package com.khahnm04.spring.ioc.v3di.constructor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.khahnm04.spring.ioc.v3di.constructor") // Tự động new bean
public class AppConfig {

    // Chủ động new bean, chủ động đặt tên, đặc biệt với các bean có tham số đầu vào


}
