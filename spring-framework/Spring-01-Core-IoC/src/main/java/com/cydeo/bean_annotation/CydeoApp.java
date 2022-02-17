package com.cydeo.bean_annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;

import java.io.IOException;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);
        FullTimeMentor fullTimeMentor = container.getBean(FullTimeMentor.class);
        fullTimeMentor.createAccount();
        container.getBean(PartTimeMentor.class).createAccount();
        String str1 = container.getBean(String.class);
        System.out.println(str1);


    }
}
