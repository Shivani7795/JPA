package com.xworkz.tourism.service;

import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepository;

public class TourismServiceImpl implements TourismService {
    TourismRepository tourismRepository;
    public TourismServiceImpl(TourismRepository tourismRepository){
        this.tourismRepository=tourismRepository;
    }
    @Override
    public boolean save(TourismEntity tourismEntity) {
        if(tourismEntity!=null){
            if (tourismEntity.getPackageName().isEmpty()) {
                System.out.println("invalid tourism name");
                return false;
            }
                if (tourismEntity.getDestination().isEmpty()) {
                System.out.println("invalid destination");
                return false;
            }
            if (tourismEntity.getDays() == null) {
                System.out.println("invalid days");
                return false;
            }
            if (tourismEntity.getPackagePrice() == null) {
                System.out.println("invalid package price");
                    return false;
            }
            if (tourismEntity.getPersonCount() == null) {
                System.out.println("invalid person count");
                return false;
            }
            System.out.println("validation passed");
            tourismRepository.saveTourism(tourismEntity);
            return true;
        }
        return false;
    }
}

