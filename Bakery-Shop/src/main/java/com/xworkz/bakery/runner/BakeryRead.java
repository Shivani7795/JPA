package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            BakeryEntity entity = em.find(BakeryEntity.class, 1); // Change '1' as needed
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at BakeryItemRead");
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
