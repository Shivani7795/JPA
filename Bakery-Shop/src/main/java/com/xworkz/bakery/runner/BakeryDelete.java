package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            // Find entity by ID
            BakeryEntity entity = em.find(BakeryEntity.class, 1);
            if (entity != null) {
                // Remove the entity
                em.remove(entity);
                System.out.println("Bakery item deleted successfully!");
            } else {
                System.out.println("No Bakery Item found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while deleting BakeryItem");
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
