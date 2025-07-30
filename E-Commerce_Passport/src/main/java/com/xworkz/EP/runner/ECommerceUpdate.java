package com.xworkz.EP.runner;


import com.xworkz.EP.entity.ECommerceEntity;

import javax.persistence.*;

public class ECommerceUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            ECommerceEntity entity = em.find(ECommerceEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setSize("M");
                entity.setPrice(799.0);
                entity.setBrand("FabWear");
                entity.setFabricType("Cotton");

                ECommerceEntity updatedEntity = em.merge(entity);
                System.out.println("Clothes item updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Clothes Item found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating Clothes item");
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
