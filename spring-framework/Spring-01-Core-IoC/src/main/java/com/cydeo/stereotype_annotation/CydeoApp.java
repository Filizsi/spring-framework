package com.cydeo.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCourse.class);
        container.getBean(Agile.class).getTeachingHours();
        container.getBean(Java.class).getTeachingHours();

        //selenium doesn't have @Component annotated
//        container.getBean(Selenium.class).getTeachingHours(); run time exception

//@Componentscan can look outside the package


    }
}
