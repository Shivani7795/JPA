package com.xworkz.EP.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "passport_application")
public class PassportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer id;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

}
