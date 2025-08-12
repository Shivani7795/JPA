package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;

public interface TourismRepository {
    void saveTourism(TourismEntity tourismEntity);
    TourismEntity findById(Integer tourismId);
}
