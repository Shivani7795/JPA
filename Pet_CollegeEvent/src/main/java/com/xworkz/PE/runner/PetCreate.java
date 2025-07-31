package com.xworkz.PE.runner;

import com.xworkz.PE.entity.PetEntity;

import javax.persistence.*;

public class PetCreate {
    public static void main(String[] args) {

        PetEntity pet = new PetEntity();
        pet.setPetName("Bruno");
        pet.setAdoptedOn("30-07-2025");
        pet.setAdopterName("Shivani");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(pet);
            et.commit();
            System.out.println("Pet adoption record inserted successfully!");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in PetCreate");
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
