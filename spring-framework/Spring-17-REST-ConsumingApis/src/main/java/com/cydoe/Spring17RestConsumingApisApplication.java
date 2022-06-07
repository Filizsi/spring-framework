package com.cydoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients //1- add this annotation to runner class,feign client required annotation
public class Spring17RestConsumingApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApisApplication.class, args);
    }

    //any config class is fine for this, created RestTemplate bean
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
