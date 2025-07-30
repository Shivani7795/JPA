package com.xworkz.EP.runner;

import com.xworkz.EP.entity.PassportEntity;

import javax.persistence.*;

public class PassportCreate {
    public static void main(String[] args) {

        PassportEntity passport = new PassportEntity();
        passport.setApplicantName("Shivani A");
        passport.setDateOfBirth("1998-12-30");
        passport.setNationality("Indian");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(passport);

            et.commit();
            System.out.println("Passport application saved successfully.");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in PassportCreate");
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
