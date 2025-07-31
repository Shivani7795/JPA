package com.xworkz.PE.runner;

import com.xworkz.PE.entity.EventEntity;

import javax.persistence.*;

public class EventCreate {
    public static void main(String[] args) {

        EventEntity event = new EventEntity();
        event.setStudentName("Shivani A");
        event.setEventName("Tech Talk 2025");
        event.setRegisteredOn("30-07-2025");
        event.setCollegeName("X-Workz Institute");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(event);
            et.commit();
            System.out.println("Event registration saved successfully!");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in EventCreate");
            if (et != null && et.isActive()) {
                et.rollback();
            }
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
