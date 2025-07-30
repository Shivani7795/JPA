package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            BakeryEntity entity = em.find(BakeryEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setItemName("Chocolate Cake");
                entity.setPrice(250.0);
                entity.setBrand("Sweet Treats");

                BakeryEntity updatedEntity = em.merge(entity);
                System.out.println("Bakery item updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Bakery Item found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating BakeryItem");
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
