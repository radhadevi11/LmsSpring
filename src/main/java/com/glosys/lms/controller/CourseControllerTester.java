package com.glosys.lms.controller;

import com.glosys.lms.controller.CourseController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseControllerTester {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.glosys.lms");
        CourseController courseController = applicationContext.getBean(CourseController.class);
        System.out.println(courseController.isExistingCourse("1234"));

    }
}
