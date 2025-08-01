package com.xworkz.application.repository;


import com.xworkz.application.entity.ApplicationEntity;

import javax.persistence.*;

public class ApplicationRepositoryImpl implements ApplicationRepository {
    EntityManagerFactory emf  = null;
    EntityManager em = null;
    EntityTransaction et = null;
    ApplicationEntity entity;


    @Override
    public void savedApplication(ApplicationEntity applicationEntity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(applicationEntity);
            et.commit();
        }catch(PersistenceException e){
            e.printStackTrace();
            System.out.println("exception in savedApplication");
        }if(emf!=null){
            emf.close();
        }if(em!=null){
            em.close();
        }
    }

    @Override
    public ApplicationEntity readApp(Integer id) {
        try{
        emf = Persistence.createEntityManagerFactory("x-workz");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        entity = em.find(ApplicationEntity.class,id);
            System.out.println(entity);
        et.commit();
    }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("exception in read");
        }if(emf!=null){
            emf.close();
        }if(em!=null){
            em.close();
        }
        return entity;
    }

    @Override
    public ApplicationEntity update(ApplicationEntity applicationEntity, Integer id) {
        try{
        emf = Persistence.createEntityManagerFactory("x-workz");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        entity = em.find(ApplicationEntity.class,id);
            System.out.println(entity);
        entity.setApplicationName(applicationEntity.getApplicationName());
        entity.setApplicationSize(applicationEntity.getApplicationSize());
        entity.setCompany(applicationEntity.getCompany());
        entity.setNoOfUsers(applicationEntity.getNoOfUsers());
        entity.setRating(applicationEntity.getRating());
        entity.setLunchTime(applicationEntity.getLunchTime());

        em.merge(entity);
        et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("exception in update");
        }if(emf!=null){
            emf.close();
        }if(em!=null){
            em.close();
        }
        return entity;
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        try{
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            entity = em.find(ApplicationEntity.class,id);
            System.out.println(entity);
            em.remove(entity);
            et.commit();

        }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("exception in update");
        }if(emf!=null){
            emf.close();
        }if(em!=null){
            em.close();
        }
        return entity;
    }
}