package com.glosys.lms.service;

import com.glosys.lms.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

   private CourseDao courseDao;
   @Autowired
   public CourseService(CourseDao courseDao) {
      this.courseDao = courseDao;
   }


   public boolean isExistingCourse(String courseCode){ return courseDao.isExistingCourse(courseCode); }

}
