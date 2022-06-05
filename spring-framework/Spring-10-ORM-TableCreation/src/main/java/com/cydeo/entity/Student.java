package com.cydeo.entity;

import com.cydeo.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="students")//change table name
public class Student {
    //how to change column name
    @Column(name = "StudentFirtName")
    private String firstName;//if came cae, it's gonna be created with under score
    @Column(name = "StudentLastName")
    private String lastName;
    @Id
    //generate primary key value, when ever u create a student id is p-key,
    // and I want u to assign p-key for me
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;

    //if we don;t want this field on the table
    @Transient
    private String city;

    //change the column definition
    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "DATETIME")
    private LocalDate birthDateAndTime;

    //if you have enum, it takes the column type as integer
    //but we want it female male structure
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
