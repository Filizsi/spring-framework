package com.cydeo.employeeregistrationproject.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    //    @NotNull            // Except null, anything can be accepted
//    @NotEmpty           // Except null and empty String anything can be accepted
//    @NotBlank           // Except null, empty String and only space anything can be accepted.

    @NotBlank
    @Size(max = 12, min = 2)
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//if we don't put this thymleaf will fail
    private LocalDate birthday;
    private String email;
    private String password;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;


}
