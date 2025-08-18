package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.utils.DBConnection;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class TourismRepositoryImpl implements TourismRepository {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction et = null;
    TourismEntity entity;
    List<TourismEntity> list = null;
    Optional<TourismEntity> optional = null;

    @Override
    public boolean save(TourismEntity tourismEntity) {

        System.out.println("save method in TourismRepositoryImpl");
        System.out.println("Repository data: " + tourismEntity);
        try {
            em = DBConnection.getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(tourismEntity);
            et.commit();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (et != null) {
                et.rollback();
                System.out.println("roll backed");
                return false;
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
                System.out.println("entityManager is closed");
            }
        }
        return true;
    }


    @Override
    public List<TourismEntity> getAllEntity() {
        try {
            em = DBConnection.getEntityManager();
            list = em.createNamedQuery("getAllEntity").getResultList();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
                System.out.println("Entity manager is closed");
            }
        }
        return list;
    }

    @Override
    public Optional<TourismEntity> findById(Integer id) {
        try {
            em = DBConnection.getEntityManager();
            TourismEntity tourism = (TourismEntity) em.createNamedQuery("findById").setParameter("id", id).getSingleResult();
            if (tourism != null) {
                return Optional.of(tourism);
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
                System.out.println("Entity manager is closed");
            }
        }
        return optional;
    }

    @Override
    public boolean update(TourismEntity entity) {
        boolean isUpdated = false;
        try {
            em = DBConnection.getEntityManager();
            et = em.getTransaction();
            et.begin();

            int updated = em.createNamedQuery("update")
                    .setParameter("packageName", entity.getPackageName())
                    .setParameter("destination", entity.getDestination())
                    .setParameter("days", entity.getDays())
                    .setParameter("packagePrice", entity.getPackagePrice())
                    .setParameter("personCount", entity.getPersonCount())
                    .setParameter("packageId", entity.getPackageId())
                    .executeUpdate();

            if (updated > 0) {
                et.commit();
                isUpdated = true;
            } else {
                et.rollback();
            }
        } catch (PersistenceException e) {
            System.out.println("Update failed: " + e.getMessage());
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return isUpdated;
    }
}
