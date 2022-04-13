package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//no need query to crete table @Entity handles it
public class Employee {

    @Id//makes it primary jey
    private int id;
    private String name;

}
