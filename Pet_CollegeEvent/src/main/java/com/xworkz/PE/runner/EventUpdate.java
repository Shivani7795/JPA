package com.xworkz.PE.runner;

import com.xworkz.PE.entity.EventEntity;

import javax.persistence.*;

public class EventUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            EventEntity entity = em.find(EventEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setStudentName("Shivani A");
                entity.setEventName("Tech Symposium");
                entity.setRegisteredOn("30-07-2025");
                entity.setCollegeName("X-Workz Engineering College");

                EventEntity updatedEntity = em.merge(entity);
                System.out.println("Event registration updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Event Registration found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating EventEntity");
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
