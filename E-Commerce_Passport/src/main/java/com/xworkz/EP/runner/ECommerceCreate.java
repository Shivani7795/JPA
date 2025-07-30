package com.xworkz.EP.runner;

import com.xworkz.EP.entity.ECommerceEntity;

import javax.persistence.*;
public class ECommerceCreate {
    public static void main(String[] args) {

        ECommerceEntity item = new ECommerceEntity();
        item.setFabricType("Denim Jacket");
        item.setPrice(1299.0);
        item.setSize("Clothing");
        item.setBrand("Levis");

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
            System.out.println("Exception in ECommerceCreate");
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
