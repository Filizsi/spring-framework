package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Entity
public class CreditAccount extends Account{
    private BigDecimal creditLimit;
}
