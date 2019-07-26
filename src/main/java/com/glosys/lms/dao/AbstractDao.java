package com.glosys.lms.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements Dao<T> {
    protected EntityManager entityManager;

    public AbstractDao() {
        entityManager = DbConnection.getEntityManager();
    }

    public AbstractDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(T t){

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }




}
