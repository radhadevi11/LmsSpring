package com.glosys.lms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Configuration
public class Config {
    @Bean
    public Engine engine(){
        return new Engine("new engine");
    }
    @Bean
    public EntityManager entityManager(){
        return  Persistence.createEntityManagerFactory("com.radha.lms").createEntityManager();
    }


}
