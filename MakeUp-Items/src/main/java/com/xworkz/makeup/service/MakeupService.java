package com.xworkz.makeup.service;

import com.xworkz.makeup.dto.MakeupDto;

import java.util.List;

public interface MakeupService {
    boolean validate(MakeupDto makeupDto);
    List<MakeupDto> getAllEntity();
}
