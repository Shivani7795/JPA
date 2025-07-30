package com.xworkz.VC.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString
@Table(name = "voter_registration")
public class VoterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voter_id")
    private Integer id;

    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

}
