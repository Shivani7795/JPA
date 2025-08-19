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
        return null;
    }

    @Override
    public String getByEmail(String email) {
        return "";
    }

    @Override
    public Long getByMobile(Long mobile) {
        return 0L;
    }
}
