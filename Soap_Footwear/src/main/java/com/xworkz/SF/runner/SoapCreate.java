package com.xworkz.SF.runner;

import com.xworkz.SF.entity.SoapEntity;

import javax.persistence.*;

public class SoapCreate {
    public static void main(String[] args) {

        SoapEntity soap = new SoapEntity();
        soap.setSoapName("Lemon Fresh");
        soap.setPrice(35.0);
        soap.setManufacturedOn("30-07-2025");
        soap.setBrand("CleanCare");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(soap);
            et.commit();
            System.out.println("SoapEntity saved successfully!");
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in SoapEntityCreate");
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
