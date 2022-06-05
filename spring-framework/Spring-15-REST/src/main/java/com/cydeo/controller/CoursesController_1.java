package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //makes it api controller + @responsebody
@RequestMapping("/course/api/v1")
public class CoursesController_1 {

    private final CourseService courseService;

    public CoursesController_1(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    @GetMapping("{id}")  //--/id
    public CourseDTO getCourseById(@PathVariable ("id") Long courseId){
        CourseDTO dto = courseService.getCourseById(courseId);
        return dto;
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);
    }


    @PostMapping()
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(courseId,courseDTO);

    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);

    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }
}
