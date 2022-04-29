package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

    //JPQL and native sql query (we can give either of them on @Query)
    //jpql -- does action on the entities
    //native sql -- goes and do the action directly on db
    //e instance of the Employee class
    @Query("Select e from Employee e where e.email = 'sdubber7@t-online.de'") //Employee is class name not table, e is instance of the class
    Employee getEmployeeDetail();

    @Query("Select e.salary from Employee e where e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("Select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    //positional ?1 first parameter of the method, ?2 get the second parameter of the method
    @Query("Select e from Employee  e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);

    //Not equal <> -- means not equal
    @Query("SELECT e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith
    @Query("SELECT e FROM Employee e where e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //Before
    @Query("SELECT e FROM Employee e where e.hireDate >?1")
    List<Employee> getEmployeeHiredDateBefore(LocalDate date);

    //Between
    @Query("SELECT e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //null
    @Query("SELECT e from Employee e where e.email is NULL")
    List<Employee> getEmployeeEmailIsNull();

    //Not null
    @Query("SELECT e from Employee e where e.email is Not NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    //sorting in ascending
    @Query("SELECT e from Employee e order by e.salary ASC ")
    List<Employee> getEmployeeSalaryOrderAscending();

    //sorting in descending
    @Query("SELECT e from Employee e order by e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDescending();

    //native query
    @Query(value="select * from employees where salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);


    //NAMED PARAMETER :NAME , ORDER IS NOT IMPORTANT, @PARAM
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    //@modiftying
    @Modifying
    @Transactional
    @Query("UPDATE Employee e set e.email='abc@email.com' where e.id = :id")
    void updateEmployeeNativeQuery(@Param("id") int id);

    //@modiftying
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees  set email='abc@email.com' where id = :id",nativeQuery = true)
    void updateEmployeeJPQL(@Param("id") int id);






}
