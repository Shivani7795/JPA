package com.xworkz.VC.runner;

import com.xworkz.VC.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            ChocolateEntity entity = em.find(ChocolateEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setIngredientName("Cocoa Powder");
                entity.setQuantity(2.5);
                entity.setUsedFor("Filling");

                ChocolateEntity updatedEntity = em.merge(entity);
                System.out.println("Chocolate ingredient updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Chocolate Ingredient found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating ChocolateIngredient");
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
