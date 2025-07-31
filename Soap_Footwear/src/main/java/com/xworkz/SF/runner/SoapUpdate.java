package com.xworkz.SF.runner;

import com.xworkz.SF.entity.SoapEntity;

import javax.persistence.*;

public class SoapUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz"); // Persistence unit
            em = emf.createEntityManager();                          // EntityManager
            et = em.getTransaction();                                // Transaction
            et.begin();

            SoapEntity entity = em.find(SoapEntity.class, 1); // Change ID as needed
            if (entity != null) {
                entity.setSoapName("Lemon Fresh");
                entity.setPrice(35.0);
                entity.setBrand("GlowCare");

                SoapEntity updatedEntity = em.merge(entity);
                System.out.println("Soap details updated successfully!");
                System.out.println(updatedEntity);
            } else {
                System.out.println("No Soap found with ID = 1");
            }

            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception occurred while updating SoapEntity");
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
