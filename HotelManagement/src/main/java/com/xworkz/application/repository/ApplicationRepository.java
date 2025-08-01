package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;

public interface ApplicationRepository {
    void savedApplication(ApplicationEntity applicationEntity);
    ApplicationEntity readApp(Integer id);
    ApplicationEntity update(ApplicationEntity applicationEntity,Integer id);
    ApplicationEntity deleteApplication(Integer id);

}
