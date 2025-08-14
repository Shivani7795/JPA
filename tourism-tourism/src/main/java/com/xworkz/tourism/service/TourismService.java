package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.entity.TourismEntity;

import java.util.List;
import java.util.Optional;

public interface TourismService {

    boolean validate(TourismDto tourismDto);
    List<TourismDto> getAllEntity();
    Optional<TourismDto> findById(Integer id);
    String updateTourism(TourismDto dto);
}
