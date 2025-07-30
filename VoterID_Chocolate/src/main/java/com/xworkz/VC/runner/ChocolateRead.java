package com.xworkz.VC.runner;

import com.xworkz.VC.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            ChocolateEntity entity = em.find(ChocolateEntity.class, 1); // Change ID as needed
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in ChocolateRead");
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
