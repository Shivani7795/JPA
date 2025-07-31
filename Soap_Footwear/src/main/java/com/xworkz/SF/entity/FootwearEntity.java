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
@Table(name = "footwear_details")
public class FootwearEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footwear_id")
    private Integer id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "size")
    private Integer size;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Double price;
}

