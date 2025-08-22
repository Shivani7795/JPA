package com.xworkz.makeup.service;

import com.xworkz.makeup.dto.MakeupDto;
import com.xworkz.makeup.entity.MakeupEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MakeupServiceImpl implements MakeupService{
    @Override
    public boolean validate(MakeupDto makeupDto) {
        System.out.println("validate method in service");
        System.out.println("service data:"+makeupDto);

        MakeupEntity mEntity = new MakeupEntity();
        BeanUtils.copyProperties(makeupDto,mEntity);
        System.out.println("Invalid details");
        return false;
    }




    @Override
    public List<MakeupDto> getAllEntity() {
        return Collections.emptyList();
    }
}
