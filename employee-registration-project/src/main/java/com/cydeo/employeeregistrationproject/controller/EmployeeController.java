package com.cydeo.employeeregistrationproject.controller;

import com.cydeo.employeeregistrationproject.boostrap.DataGenerator;
import com.cydeo.employeeregistrationproject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());
        return "employee/employee-create";
    }


    @PostMapping("/list")
    public String employeeList(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){

        //if there is an error on the page, stay in the same page
        if(bindingResult.hasErrors()){
            model.addAttribute("states", DataGenerator.getAllStates());

            return "employee/employee-create";
        }

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());

        return "employee/employee-list";
    }
}
