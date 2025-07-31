package com.xworkz.PE.entity;

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
@Table(name = "pet_adoption")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "adopted_on")
    private String adoptedOn;

    @Column(name = "adopter_name")
    private String adopterName;
}
