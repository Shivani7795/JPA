package com.xworkz.EP.runner;

import com.xworkz.EP.entity.PassportEntity;

import javax.persistence.*;

public class PassportUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Load persistence unit
            em = emf.createEntityManager(); // Create EntityManager
            et = em.getTransaction();       // Get transaction
            et.begin();

            PassportEntity entity = em.find(PassportEntity.class, 1); // Change '1' if needed
            if (entity != null) {
                entity.setApplicantName("Rohit Sharma");
                entity.setDateOfBirth("30-04-1987");
                entity.setNationality("Indian");

                PassportEntity updatedEntity = em.merge(entity);
                System.out.println("Passport application updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Passport Application found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating PassportApplication");
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
