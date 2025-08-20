package com.xworkz.login.repository;

import com.xworkz.login.entity.LoginEntity;

public interface LoginRepository {
    boolean save(LoginEntity entity);
    LoginEntity acceptLogin();
    String getByMail(String mail);
    Long getByMobile(Long mobile);

}
