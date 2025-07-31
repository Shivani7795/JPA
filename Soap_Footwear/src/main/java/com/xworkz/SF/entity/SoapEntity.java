package com.xworkz.SF.entity;


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
@Table(name = "soap_details")
public class SoapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soap_id")
    private Integer id;

    @Column(name = "soap_name")
    private String soapName;

    @Column(name = "price")
    private Double price;

    @Column(name = "manufactured_on")
    private String manufacturedOn;

    @Column(name = "brand")
    private String brand;
}
