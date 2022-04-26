package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //method - sql-derive query-findById(int it) -- selects * from payment where id =
    //we need to follow name convention
    //introducer - find, read,get, query, count
    //criteria- start after the by key word


    //write sql query - annotate @Query
    //JPQl - @Query
}
