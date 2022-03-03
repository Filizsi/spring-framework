package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// annotates the calss woth the @controller stereotype annotation
public class HomeController {
    @RequestMapping("/home")//use @Request mapping annotation to associate with an HTTP request path
    public String home(){
        return "home.html";//return th html document name that contains the details we want the browser to display
    }

    @RequestMapping("/welcome")//end point
    public String home2(){
        return "welcome.html";
    }

    //if we don't put any end point default is "/"
    @RequestMapping
    public String home3(){
        return "welcome.html";
    }



}
