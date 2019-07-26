package com.glosys.lms;


import com.glosys.lms.dao.CourseDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarTester {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.glosys.lms");
        Car car = context.getBean(Car.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        System.out.println(car.getEngine().getEngineType());

    }

}
