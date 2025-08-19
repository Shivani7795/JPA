package com.xworkz.login.service;

import com.xworkz.login.dto.LoginDto;

public interface LoginService {
    boolean save(LoginDto dto);
    LoginDto acceptLogin(String email,String password);
    String getByEmail(String email);
    Long getByMobile(Long mobile);
}
