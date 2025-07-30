package com.xworkz.VC.runner;

import com.xworkz.VC.entity.VoterEntity;

import javax.persistence.*;

public class VoterCreate {
    public static void main(String[] args) {

        VoterEntity voter = new VoterEntity();
        voter.setCandidateName("Rahul Sharma");
        voter.setAge(28);
        voter.setGender("Male");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(voter);
            et.commit();
            System.out.println("Voter registered successfully: " + voter);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in VoterCreate");
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
