package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="departments")
public class Department extends BaseEntity{

    private String department;
    private String division;

    @OneToOne(mappedBy = "department")//this name must match exactly the same field name in employee class
    //I don't want the foreign column on department table, hybernate is not gonna create foreign key, it belongs to Employee
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
