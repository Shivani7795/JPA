package com.xworkz.VC.runner;

import com.xworkz.VC.entity.VoterEntity;

import javax.persistence.*;

public class VoterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load and register persistence unit
            em = emf.createEntityManager(); // DML and DQL operations
            et = em.getTransaction();       // Transaction control
            et.begin();

            VoterEntity entity = em.find(VoterEntity.class, 1); // Find by ID
            if (entity != null) {
                entity.setCandidateName("Ravi Kumar");
                entity.setAge(42);
                entity.setGender("Male");

                VoterEntity updatedEntity = em.merge(entity);
                System.out.println("Voter record updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Voter found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating Voter record");
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
