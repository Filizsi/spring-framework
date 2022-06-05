package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    //because of country and state ate defined as variable
    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(Role role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a from Account a ")
    List<Account> fetchAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a from Account a where a.role = ?1")
    List<Account> fetchUsersByRole(String role);

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a from Account a order by a.age desc")
    List<Account> orderWithAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * from account_details where age < :age1", nativeQuery = true)
//    @Query(value = "SELECT * from account_details where age < ?1",nativeQuery = true)
    List<Account> retrieveAllByAgeLessThan(@Param("age") int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    @Query(value = "Select * from account_details where name IlIKE concat('%',?1,'%') +" +
            "OR country IlIKE concat('%',?1,'%')" +
            "OR state IlIKE concat('%',?1,'%')" +
            "OR city IlIKE concat('%',?1,'%')", nativeQuery = true)
    List<Account> retrieveBySearchCriteria(@Param("pattern") String pattern);
    //@param takes the 'DROP DATABASE' on single coat, otherwise quesry takes it as ending

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * from account_details where age > ?1", nativeQuery = true)
    List<Account> retrieveHigherThanAge(@Param("age") Integer age);
}
