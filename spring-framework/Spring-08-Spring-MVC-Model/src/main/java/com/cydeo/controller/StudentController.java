package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){
        //model methods
        //addAttribute accepts 2 parameters
        //these attributes are local, belongs to this method
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        return"/student/welcome";
    }


}
