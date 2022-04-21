package com.cydeo.entity;

import javax.persistence.*;

@MappedSuperclass //just for inheritance, no object from this class
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
