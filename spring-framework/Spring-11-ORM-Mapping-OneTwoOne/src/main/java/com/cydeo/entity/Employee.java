package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String firstName;
    private String latName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hiredDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)//one entity associated wit one entity, join
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "department_id")// change the foreign column name
    //joinColumn mean foreign key
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;



    public Employee(String firstName, String latName, String email, LocalDate hiredDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.latName = latName;
        this.email = email;
        this.hiredDate = hiredDate;
        this.gender = gender;
        this.salary = salary;
    }
}
