package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//no need query to crete table @Entity handles it
public class Employee {

    @Id//makes it primary jey
    private int id;
    private String name;

    //raw is missing, whenever we created object with new, it's gonna generate the raw for us

}
