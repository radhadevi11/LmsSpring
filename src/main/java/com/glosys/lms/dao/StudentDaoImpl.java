package com.glosys.lms.dao;

import com.glosys.lms.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class StudentDaoImpl extends AbstractDao<Student> {
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        super(entityManager);

    }

}
