package com.xworkz.tourism.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.activation.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.xworkz.tourism")
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class TourismConfiguration implements WebMvcConfigurer {



    @Autowired
    private Environment environment;
    public TourismConfiguration(){
        System.out.println("Tourism const");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        System.out.println("InternalResourceViewResolver method");
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("/image/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
}

