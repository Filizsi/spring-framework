package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @RequestMapping("/list")
    public String mentor(Model model) {

        Mentor mentor = new Mentor("Mike", "Smith", 45, Gender.MALE);
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentorList.add(new Mentor("Ammy", "Bryan", 65, Gender.FEMALE));

        model.addAttribute("mentors", mentorList);


        return "/mentor/MentorInfo";
    }


}
