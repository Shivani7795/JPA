package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;

import java.time.LocalDate;

public interface ApplicationRepository {
    void savedApplication(ApplicationEntity applicationEntity);
    ApplicationEntity readApp(Integer id);
    ApplicationEntity update(ApplicationEntity applicationEntity,Integer id);
    ApplicationEntity deleteApplication(Integer id);
    ApplicationEntity getApplicationByName(String name);
    ApplicationEntity getApplicationBySize(String size);
    ApplicationEntity getApplicationByCompany(String company);
    ApplicationEntity getApplicationByNoOfUsers(Integer noOfUsers);
    ApplicationEntity getApplicationByRating(Float rating);
    ApplicationEntity getApplicationByLunchTime(LocalDate localDate);


}
