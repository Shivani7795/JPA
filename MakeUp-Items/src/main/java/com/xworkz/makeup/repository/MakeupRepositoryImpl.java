package com.xworkz.makeup.repository;

import com.xworkz.makeup.entity.MakeupEntity;
import com.xworkz.makeup.utils.DBConnection;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;

@Repository
public class MakeupRepositoryImpl implements MakeupRepository{
    public MakeupRepositoryImpl(){
        System.out.println("MakeupRepositoryImpl const");
    }
    EntityManager em = null;
    EntityTransaction et = null;
    List<MakeupEntity> listMakeupEntity = null;

    @Override
    public boolean save(MakeupEntity saveMakeupEntity) {
        System.out.println("save method in repo");
        System.out.println("repository data:"+ saveMakeupEntity);
        try{
            em = DBConnection.getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(saveMakeupEntity);
            et.commit();
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if(et != null){
                et.rollback();
                System.out.println("roll Backed");
                return false;
            }
        }finally{
            if(em !=null && em.isOpen()){
                em.close();
                System.out.println("entityManager is closed");
            }
        }
        return true;
    }

    @Override
    public List<MakeupEntity> getAllEntity() {
        System.out.println("getAllEntity Method in repo");
        try{
            em = DBConnection.getEntityManager();
            listMakeupEntity = em.createNamedQuery("getAllEntity").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em != null && em.isOpen()){
                em.close();
                System.out.println("entityManager is closed");
            }
        }
        return listMakeupEntity;
    }
}
