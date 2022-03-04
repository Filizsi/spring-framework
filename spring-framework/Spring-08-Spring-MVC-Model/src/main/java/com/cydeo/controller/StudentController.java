package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){
        //model methods
        //addAttribute accepts 2 parameters
        //these attributes are local, belongs to this method
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        String subject = "Collections";
        model.addAttribute("subject",subject);

        //create student id,
        int id = new Random().nextInt();
        model.addAttribute("id",id);

        //list
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(11);
        model.addAttribute("numbers",numbers);

        Student student = new Student(1,"Mike","Smith");
        //value is the student object
        model.addAttribute("student",student);

        //no .html anymore, because this is thymeleaf
        return"/student/welcome";
    }

    @RequestMapping("/list")
    public String mentor(Model model) {

        Mentor mentor = new Mentor("Mike", "Smith", 45, Gender.MALE);
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mikessss", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentorList.add(new Mentor("Ammy", "Bryan", 65, Gender.FEMALE));

        model.addAttribute("mentors", mentorList);


        return "/mentor/MentorInfo";
    }







}
