package com.xworkz.PE.runner;

import com.xworkz.PE.entity.PetEntity;

import javax.persistence.*;

public class PetUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            PetEntity entity = em.find(PetEntity.class, 1); // Find by pet ID
            if (entity != null) {
                entity.setPetName("Buddy");
                entity.setAdopterName("Aarav Singh");
                entity.setAdoptedOn("30-07-2025");

                PetEntity updatedEntity = em.merge(entity);
                System.out.println("Pet adoption details updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Pet record found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating PetEntity");
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
