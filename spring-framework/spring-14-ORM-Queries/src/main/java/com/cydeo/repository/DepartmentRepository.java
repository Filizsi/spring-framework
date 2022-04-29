package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    //Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all the departments in the Health division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display top 3 departments with division name includes Hea without duplicate
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

    //IN -- list of strings
    @Query("SELECT d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

    //
    List<Department> retrieveDepartmentByDivision(String division);
}
