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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

//    @NotNull //excepts null, anything can be accepted
//    @NotEmpty //except null and empty string anything can be accepted
//    @NotBlank //except null, empty string and only space, anything can be accepted
    @NotBlank
    @Size(max=12,min=2)
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate birthDay;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;



}
