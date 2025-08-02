package com.xworkz.application.runner;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepository;
import com.xworkz.application.repository.ApplicationRepositoryImpl;
import com.xworkz.application.service.ApplicationService;
import com.xworkz.application.service.ApplicationServiceImpl;

import java.time.LocalDate;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationEntity applicationEntity = new ApplicationEntity();
        ApplicationRepository applicationRepository=new ApplicationRepositoryImpl();
        ApplicationService applicationService = new ApplicationServiceImpl(applicationRepository);

//        applicationEntity.setApplicationName("Nandini hotel");
//        applicationEntity.setApplicationSize("50");
//        applicationEntity.setCompany("nandini");
//        applicationEntity.setRating(3.5f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(100);
//        applicationService.save(applicationEntity);

//        applicationEntity.setApplicationName("Trupti hotel");
//        applicationEntity.setApplicationSize("45");
//        applicationEntity.setCompany("trupti");
//        applicationEntity.setRating(4.5f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(76);
//        applicationService.save(applicationEntity);
//
//        applicationEntity.setApplicationName("Canara hotel");
//        applicationEntity.setApplicationSize("87");
//        applicationEntity.setCompany("Canara");
//        applicationEntity.setRating(3.8f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(67);
//        applicationService.save(applicationEntity);
//
//        applicationEntity.setApplicationName("Indraprasta hotel");
//        applicationEntity.setApplicationSize("34");
//        applicationEntity.setCompany("Indraprasta");
//        applicationEntity.setRating(3.2f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(65);
//        applicationService.save(applicationEntity);

//        applicationEntity.setApplicationName("Udupi hotel");
//        applicationEntity.setApplicationSize("54");
//        applicationEntity.setCompany("Udupi");
//        applicationEntity.setRating(4.2f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(67);
//        applicationService.save(applicationEntity);
//
//        applicationEntity.setApplicationName("Adiyogi hotel");
//        applicationEntity.setApplicationSize("89");
//        applicationEntity.setCompany("Adiyogi");
//        applicationEntity.setRating(4.3f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(65);
//        applicationService.save(applicationEntity);

//        applicationRepository.readApp(1);
//
//        applicationEntity.setApplicationName("Reyansh hotel");
//        applicationEntity.setApplicationSize("50");
//        applicationEntity.setCompany("Reyansh");
//        applicationEntity.setRating(5.0f);
//        applicationEntity.setLunchTime(LocalDate.now());
//        applicationEntity.setNoOfUsers(80);
//        applicationRepository.update(applicationEntity, 1);
//
//        applicationRepository.readApp(1);

//        applicationRepository.deleteApplication(7);

 //       applicationRepository.getApplicationByName("Reyansh hotel");
          applicationRepository.getApplicationBySize("89");

    }
}
