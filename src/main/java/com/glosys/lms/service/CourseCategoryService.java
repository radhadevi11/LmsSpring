package com.glosys.lms.service;


import com.glosys.lms.dao.CourseCategoryDao;
import com.glosys.lms.entities.CourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CourseCategoryService {
    private CourseCategoryDao courseCategoryDao;
    @Autowired
    public CourseCategoryService(CourseCategoryDao courseCategoryDao){
        this.courseCategoryDao = courseCategoryDao;
    }

    public List<CourseCategory> getCourseCategories(){
        return courseCategoryDao.getCourseCategories();
    }

    public int saveCourseCategory(CourseCategory courseCategory) {
        return courseCategoryDao.save(courseCategory);
    }
}
