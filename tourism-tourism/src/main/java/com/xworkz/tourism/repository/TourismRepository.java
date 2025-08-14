package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;

import java.util.List;
import java.util.Optional;

public interface TourismRepository {
    boolean save(TourismEntity entity);
    List<TourismEntity> getAllEntity();
    Optional<TourismEntity> findById(Integer id);
    boolean update(TourismEntity entity);



}
