package com.xworkz.login.service;

import com.xworkz.login.dto.LoginDto;
import com.xworkz.login.entity.LoginEntity;
import com.xworkz.login.repository.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean save(LoginDto dto) {
        LoginEntity entity = new LoginEntity();
        BeanUtils.copyProperties(dto,entity);
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setPresent(true);
        return loginRepository.save(entity);
    }

    @Override
    public LoginDto acceptLogin(String email, String password) {
        LoginEntity entity = loginRepository.acceptLogin();

        if(entity == null){
            return  null;
        }
        if(!encoder.matches(password,entity.getPassword())){
            return null;
        }
        LoginDto dto = new LoginDto();
        BeanUtils.copyProperties(entity,dto);
        System.out.println("service fetch by login"+ entity);
        return dto;
    }

    @Override
    public String getByEmail(String email) {
        System.out.println("getByEmail in service");
        return loginRepository.getByMail(email);
    }

    @Override
    public Long getByMobile(Long mobile) {
        System.out.println("getByMobile in service");
        return loginRepository.getByMobile(mobile);
    }
}
