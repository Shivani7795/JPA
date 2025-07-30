package com.xworkz.EP.runner;

import com.xworkz.EP.entity.PassportEntity;

import javax.persistence.*;

public class PassportRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            PassportEntity entity = em.find(PassportEntity.class, 1); // Change '1' as needed
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at PassportRead");
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
