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

        applicationEntity.setApplicationName("Nandini hotel");
        applicationEntity.setApplicationSize("50");
        applicationEntity.setCompany("nandini");
        applicationEntity.setRating(3.5f);
        applicationEntity.setLunchTime(LocalDate.now());
        applicationEntity.setNoOfUsers(100);
        applicationService.save(applicationEntity);

        applicationRepository.readApp(1);

        applicationEntity.setApplicationName("Reyansh hotel");
        applicationEntity.setApplicationSize("50");
        applicationEntity.setCompany("Reyansh");
        applicationEntity.setRating(5.0f);
        applicationEntity.setLunchTime(LocalDate.now());
        applicationEntity.setNoOfUsers(80);
        applicationRepository.update(applicationEntity, 1);

        applicationRepository.readApp(1);

        applicationRepository.deleteApplication(2);
    }
}
