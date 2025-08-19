package com.xworkz.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.makeup")
@EnableWebMvc
public class LoginConfiguration implements WebMvcConfigurer {
    public LoginConfiguration(){
        System.out.println("loginconfiguration const");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        System.out.println("InternalResourceViewResolver const");
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setPrefix(".jsp");
        return internalResourceViewResolver;
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    public BCryptPasswordEncoder cryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
