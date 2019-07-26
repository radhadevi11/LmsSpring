package com.glosys.lms.controller;

import com.glosys.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseController {

    private static CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public boolean isExistingCourse(String courseCode){ return courseService.isExistingCourse(courseCode); }


}
