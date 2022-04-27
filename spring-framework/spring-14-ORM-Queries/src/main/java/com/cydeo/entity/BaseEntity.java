package com.cydeo.entity;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    private Long id;
}
