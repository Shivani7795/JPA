package com.xworkz.SF.runner;

import com.xworkz.SF.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearCreate {
    public static void main(String[] args) {

        FootwearEntity footwear = new FootwearEntity();
        footwear.setBrandName("Nike");
        footwear.setSize(9);
        footwear.setColor("Black");
        footwear.setPrice(3999.0);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(footwear);
            et.commit();
            System.out.println("Footwear details inserted successfully!");
            System.out.println(footwear);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in FootwearCreate");
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
