package com.xworkz.login.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "login_info")

public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "regName")
    private String regName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private Long mobile;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "state")
    private String state;

    @Column(name = "password")
    private String password;

    @Column(name = "cpassword")
    private String cpassword;

    private boolean isPresent;
}
