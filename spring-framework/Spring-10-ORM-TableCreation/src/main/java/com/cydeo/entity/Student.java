package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private String firstName;
    private String lastname;
    @Id
    private int id;
    private String email;
}
