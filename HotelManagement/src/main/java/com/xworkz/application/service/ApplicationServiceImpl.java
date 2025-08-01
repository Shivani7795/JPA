package com.xworkz.application.service;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepository;

public class ApplicationServiceImpl implements ApplicationService{
    ApplicationRepository applicationRepository;
    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean save(ApplicationEntity applicationEntity) {
        if(applicationEntity!=null) {
            if (applicationEntity.getApplicationName().isEmpty()) {
                System.out.println("invalid Application Name");
                return false;
            }
            if (applicationEntity.getApplicationSize().isEmpty()) {
                System.out.println("invalid Application Size");
                return false;
            }
            if(applicationEntity.getCompany().isEmpty()){
                System.out.println("invalid company");
                return false;
            }
            if(applicationEntity.getRating()==null){
                System.out.println("invalid rating");
                return false;
            }
            if(applicationEntity.getNoOfUsers()==null){
                System.out.println("invalid no of users");
                return false;
            }
            System.out.println("validation passed");
            applicationRepository.savedApplication(applicationEntity);
            return true;
        }
        return false;
    }
}
