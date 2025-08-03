package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryCreate {
    public static void main(String[] args) {

        BakeryEntity item = new BakeryEntity();
        item.setItemName("Chocolate Cake");
        item.setPrice(250.0);
        item.setBakedOn("30-07-2025");
        item.setBrand("SweetTreats");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(item);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in BakeryItemCreate");
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
        finally
        {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
