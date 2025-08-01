package com.xworkz.application.entity;

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
@Table(name = "application_info")
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_Name")
    private String applicationName;

    @Column(name = "application_size")
    private String applicationSize;

    @Column(name = "company_name")
    private String company;

    @Column(name = "no_of_users")
    private Integer  noOfUsers;

    @Column(name = "ratings")
    private Float rating;

    @Column(name = "date")
    private LocalDate lunchTime;
}

