package com.glosys.lms.service;

import com.glosys.lms.dao.StudentDaoImpl;
import com.glosys.lms.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    private StudentDaoImpl studentDao;

    @Autowired
    public StudentService(StudentDaoImpl studentDao){
        this.studentDao = studentDao;
    }
    public int saveStudent(Student student){
        return studentDao.save(student);
    }

}
