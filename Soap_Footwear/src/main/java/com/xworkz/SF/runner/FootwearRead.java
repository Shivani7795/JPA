package com.xworkz.SF.runner;

import com.xworkz.SF.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            FootwearEntity entity = em.find(FootwearEntity.class, 1); // Replace '1' with the desired ID
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at FootwearRead");
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
