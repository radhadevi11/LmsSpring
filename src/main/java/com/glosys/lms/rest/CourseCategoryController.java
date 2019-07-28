package com.glosys.lms.rest;

import com.glosys.lms.entities.CourseCategory;
import com.glosys.lms.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseCategories")
public class CourseCategoryController {
    private CourseCategoryService courseCategoryService;

    @Autowired
    public CourseCategoryController(CourseCategoryService courseCategoryService) {
        this.courseCategoryService = courseCategoryService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SavedResource saveCourseCategory(@RequestBody CourseCategory courseCategory){
        return new SavedResource(courseCategoryService.saveCourseCategory(courseCategory));
    }
}
