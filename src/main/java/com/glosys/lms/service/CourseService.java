package com.glosys.lms.service;

import com.glosys.lms.entities.Course;
import com.glosys.lms.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseService {

   private CourseDao courseDao;
   @Autowired
   public CourseService(CourseDao courseDao) {
      this.courseDao = courseDao;
   }

   public int saveCourse(Course course){ return courseDao.save(course);}

   public Optional<Course> getCourseByCourseId(int courseId){ return courseDao.getCourseByCourseId(courseId);}


   public boolean isExistingCourse(String courseCode){ return courseDao.isExistingCourse(courseCode); }

}
