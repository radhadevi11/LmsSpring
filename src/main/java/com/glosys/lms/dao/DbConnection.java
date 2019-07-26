package com.glosys.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {

    public static EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("com.radha.lms");

    }
    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }
}
