package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {
    @Bean
    Car car(){
        Car c =  new Car();
        c.setMake("Honda");
        return c;
    }

    //direct wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car());
//        return p;
//    }

    //auto wire$Fsi2879

    @Bean
    Person person(Car car){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }


}
