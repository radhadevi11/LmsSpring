package com.glosys.lms.dao;

import com.glosys.lms.entities.LmsEntity;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T extends LmsEntity> implements Dao<T> {
    protected EntityManager entityManager;

    public AbstractDao() {
        entityManager = DbConnection.getEntityManager();
    }

    public AbstractDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Integer save(T t){

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return t.getId();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
           throw new RuntimeException("can not save entity",e);
        }

    }




}
