package com.xworkz.SF.runner;

import com.xworkz.SF.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load persistence unit
            em = emf.createEntityManager(); // Create entity manager
            et = em.getTransaction();       // Begin transaction
            et.begin();

            FootwearEntity entity = em.find(FootwearEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setBrandName("Puma");
                entity.setSize(9);
                entity.setColor("Black");
                entity.setPrice(1999.99);

                FootwearEntity updatedEntity = em.merge(entity);
                System.out.println("Footwear item updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Footwear item found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating Footwear item");
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
