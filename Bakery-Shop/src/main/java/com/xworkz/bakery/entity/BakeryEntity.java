package com.xworkz.bakery.entity;

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
@Table(name = "bakery_items")
public class BakeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private Double price;

    @Column(name = "baked_on")
    private String bakedOn;

    @Column(name = "brand")
    private String brand;
}
