package com.xworkz.login.repository;

import com.xworkz.login.entity.LoginEntity;
import com.xworkz.login.utils.DBConnection;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class LoginRepositoryImpl implements LoginRepository{

    @Autowired
    private DBConnection dbConnection;

    @Override
    public boolean save(LoginEntity entity) {
        EntityManager em = null;
        boolean isSaved = false;
        try{
            em = dbConnection.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);

            if (entity!=null){
                em.getTransaction().commit();
                System.out.println("data saved");
                return isSaved=true;
            }
        }catch (QueryException | NoResultException e){
            System.out.println(e.getMessage());
            isSaved = false;
        }
        return isSaved;
    }

    @Override
    public LoginEntity acceptLogin() {
        return null;
    }

    @Override
    public String getByMail(String mail) {
        return "";
    }

    @Override
    public Long getByMobile(Long mobile) {
        return 0L;
    }
}
