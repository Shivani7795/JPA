package com.xworkz.PE.runner;

import com.xworkz.PE.entity.EventEntity;

import javax.persistence.*;

public class EventRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            EventEntity entity = em.find(EventEntity.class, 1); // Change ID as needed
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at EventRead");
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
