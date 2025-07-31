package com.xworkz.PE.runner;

import com.xworkz.PE.entity.PetEntity;

import javax.persistence.*;

public class PetRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            PetEntity entity = em.find(PetEntity.class, 1); // Replace 1 with desired pet_id
            System.out.println(entity);

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at PetRead");
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
