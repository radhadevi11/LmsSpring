package com.glosys.lms.rest;

import com.glosys.lms.entities.Course;
import com.glosys.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    private CourseService courseService;
    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    public boolean isExistingCourse(String courseCode){ return courseService.isExistingCourse(courseCode); }

    @GetMapping
    public Course getCourse(@RequestParam(value = "id") int courseId){
        Optional<Course> courseOptional = courseService.getCourseByCourseId(courseId);
        return courseOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No course found"));

    }
    @PostMapping( consumes = "application/json", produces = "application/json")
    public SavedResource saveCourse(@RequestBody Course course){
        return new SavedResource(courseService.saveCourse(course));
    }

}
