package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;

import javax.persistence.*;

public class TourismRepositoryImpl implements TourismRepository{

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction et = null;
    TourismEntity entity;

    @Override
    public void saveTourism(TourismEntity tourismEntity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(tourismEntity);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in saveTourism");
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    @Override
    public TourismEntity findById(Integer tourismId) {
        try{
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            entity = (TourismEntity) em.createNamedQuery("findById").setParameter("tourismId",tourismId).getSingleResult();
            System.out.println("findById:"+entity);
            et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("exception in getApplicationByName");
        }if(emf!=null){
            emf.close();
        }if(em!=null){
            em.close();
        }
        return entity;
    }
}
