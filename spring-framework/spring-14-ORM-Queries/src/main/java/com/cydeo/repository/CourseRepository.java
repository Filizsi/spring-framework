package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //derive queries - find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category an order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if course with the provided name exist return true
     boolean existsByName(String name);

     //return the count of the courses for the provided category
    int countByCategory(String category);

    //find all courses that starts with the provided course name
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream
    Stream <Course> streamByCategory(String category);

    @Query("SELECT c from Course c where c.category = :category AND c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category,@Param("rating") int rating);




}
