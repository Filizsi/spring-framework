package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {
    @Bean
    FullTimeMentor fullTimeMentor() {
        return new FullTimeMentor();
    }

//    @Bean(name = "P1"), multiple configuration
    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }

//    @Bean(name = "P2")
    @Bean
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }
}
