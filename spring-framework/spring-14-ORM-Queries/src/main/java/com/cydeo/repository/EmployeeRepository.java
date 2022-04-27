package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //display all employees with email address "something"
    List<Employee> findByEmail(String email);

    //displayy all employees with firtsname "" ans last name "" also show all employees with email address

    List<Employee> findByFirstNameAndLastNameAndEmailIsNotNull(String firstName, String lastName);
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName,String email);

    //display all employees that first name is not something
    List<Employee> findByFirstNameIsNot(String firstname);

    //display all  employes where last name starts with
    List<Employee> findByLastNameStartingWith(String pattern);

    //display all employees with salaries higher then   ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all the employees with salaries less then equal
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //displayy all employees that has been hire d between date to date
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //displayy all employees where salries greate and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top unique 3 employees that is making less then
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    //JPQL
    @Query("Select e from Employee e where e.email = 'sdubber7@t-online.de'") //Employee is class name not table, e is instance of the class
    Employee getEmployeeDetail();

    @Query("Select e.salary from Employee e where e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("Select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("Select e from Employee  e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);



}
