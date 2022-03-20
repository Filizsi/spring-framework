package com.cydeo.controller;

import com.cydeo.boostrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student") //we dont update this one on class level, @GetMapping("/register") is for method level ONLY
public class StudentController {
    //GET method is default, if we don't specify it, it means default GET
    //when we work with UI we use only GET and POST
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudents());

        return "student/register"; //return view

    }

//    @RequestMapping("/welcome")
    @GetMapping("/welcome")
    public String info(){

        return "student/welcome";
    }

}
