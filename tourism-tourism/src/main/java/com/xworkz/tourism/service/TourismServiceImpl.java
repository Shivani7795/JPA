package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourismServiceImpl implements TourismService {
    @Autowired
    private TourismRepository tourismRepository;


        @Override
        public boolean validate (TourismDto tourismDto){
            System.out.println("validate method in service");
            System.out.println("Service data: " + tourismDto);



                TourismEntity tourism = new TourismEntity();
                tourism.setPackageName(tourismDto.getPackageName());
                tourism.setDestination(tourismDto.getDestination());
                tourism.setDays(tourismDto.getDays());
                tourism.setPackagePrice(tourismDto.getPackagePrice());
                tourism.setPersonCount(tourismDto.getPersonCount());
            System.out.println("Invalid details");

                return tourismRepository.save(tourism);

        }

        @Override
        public List<TourismDto> getAllEntity () {
            System.out.println("getAllEntity method in service");
            List<TourismEntity> listOfTourismEntity = tourismRepository.getAllEntity();
            List<TourismDto> listOfTourismDto = listOfTourismEntity.stream()
                    .map(entity -> {
                        TourismDto dto = new TourismDto();
                        dto.setPackageId(entity.getPackageId());
                        dto.setPackagePrice(entity.getPackagePrice());
                        dto.setDays(entity.getDays());
                        dto.setDestination(entity.getDestination());
                        dto.setPackageName(entity.getPackageName());
                        dto.setPersonCount(entity.getPersonCount());
                        return dto;
                    })
                    .collect(Collectors.toList());

            return listOfTourismDto;
        }

        @Override
        public Optional<TourismDto> findById (Integer id){
            System.out.println("finById method in service");
            if (id != null && id > 0) {
                System.out.println("id is valid");
                Optional<TourismEntity> optionalTourismEntity = tourismRepository.findById(id);
                if (optionalTourismEntity.isPresent()) {
                    TourismEntity entity = new TourismEntity();
                    entity = optionalTourismEntity.get();
                    TourismDto dto = new TourismDto();
                    dto.setPackageId(entity.getPackageId());
                    dto.setPersonCount(entity.getPersonCount());
                    dto.setPackagePrice(entity.getPackagePrice());
                    dto.setDays(entity.getDays());
                    dto.setDestination(entity.getDestination());
                    dto.setPackageName(entity.getPackageName());
                    Optional<TourismDto> optionalTourismDTO = Optional.of(dto);
                    return optionalTourismDTO;
                }
            } else {
                System.out.println("id in not valid");
            }
            return Optional.empty();
        }

    @Override
    public String updateTourism(TourismDto dto) {
            TourismEntity entity = new TourismEntity();
        BeanUtils.copyProperties(dto,entity);
        boolean updated = tourismRepository.update(entity);
        if(updated){
            return "updated";
        }
        return "not updated";
    }
}
