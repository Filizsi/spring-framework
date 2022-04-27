package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    //Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all the departments in the Health division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display top 3 departments with division name includes Hea without duplicate
    List<Department> findDistinctTop3ByDivisionContains(String pattern);
}
