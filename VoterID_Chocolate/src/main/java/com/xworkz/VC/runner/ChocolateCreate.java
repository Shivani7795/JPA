package com.xworkz.VC.runner;

import com.xworkz.VC.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateCreate {
    public static void main(String[] args) {

        ChocolateEntity ingredient = new ChocolateEntity();
        ingredient.setIngredientName("Cocoa Powder");
        ingredient.setQuantity(200.0);
        ingredient.setUsedFor("Dark Chocolate");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(ingredient);
            et.commit();
            System.out.println("Chocolate ingredient saved successfully: " + ingredient);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in ChocolateCreate");
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
