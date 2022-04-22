package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    @OneToMany(mappedBy = "customer",fetch= FetchType.LAZY)//we give ownership to many side
    //fetch= FetchType.LAZY- just give me what I need, merchant info comes when ever needed
    //fetch= FetchType.LAZY - give me everything, merchant info comes by default
    private List<Payment> payment;

    public Customer(String address, String email, String name, String surName, String username) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = username;
    }
}
