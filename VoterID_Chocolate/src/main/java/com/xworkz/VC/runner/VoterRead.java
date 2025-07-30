package com.xworkz.VC.runner;

import com.xworkz.VC.entity.VoterEntity;

import javax.persistence.*;

public class VoterRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            VoterEntity entity = em.find(VoterEntity.class, 1); // Change ID as needed
            if (entity != null) {
                System.out.println("Voter found: " + entity);
            } else {
                System.out.println("No Voter found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception at VoterRead");
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
