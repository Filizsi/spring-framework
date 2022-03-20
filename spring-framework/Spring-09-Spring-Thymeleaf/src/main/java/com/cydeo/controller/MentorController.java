package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("mentor", new Mentor());
        //this is initial loading, not belongs to object
        List<String> batchList = Arrays.asList("JD1","JD2","EU1");
        model.addAttribute("batchList",batchList);
        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String showForm2(@ModelAttribute("mentor") Mentor mentor){
      //here we need to have the created object when we click on register button which is on line 19(local variable)
        //if you wanna caprute any local attribute (line 19) we use @ModelAttribute("mentor") Mentor mentor
//        System.out.println(mentor.toString());
//        return "mentor/mentor-confirm";
        //inorder to see the register page empty again after clicking the register button
        return "redirect:/mentor/register";
    }

}
