package com.glosys.lms.rest;

import com.glosys.lms.entities.Student;
import com.glosys.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SavedResource saveStudent(@RequestBody Student student){
        return new SavedResource(studentService.saveStudent(student));
    }


}
