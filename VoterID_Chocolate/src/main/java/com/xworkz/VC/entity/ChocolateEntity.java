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
@Table(name = "chocolate_ingredients")
public class ChocolateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "used_for")
    private String usedFor;
}
