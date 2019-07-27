package com.glosys.lms.dao;

import com.glosys.lms.entities.LmsEntity;

public interface Dao<T extends LmsEntity> {
    Integer save(T t);

}
