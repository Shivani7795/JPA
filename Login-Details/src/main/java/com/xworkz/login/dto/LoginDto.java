package com.xworkz.login.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class LoginDto {

    @Size(min=2,max=30)
    private String regName;

    @Size(min=2,max=50)
    private String email;

    @Min(10)
    private Long mobile;

    private LocalDate dob;

    @Size(min=2,max=30)
    private String state;

    @Size(min=2,max=30)
    private String password;

    @Size(min=2,max=30)
    private String cpassword;
}
