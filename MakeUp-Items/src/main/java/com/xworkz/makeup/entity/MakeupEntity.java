package com.xworkz.makeup.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "makeup_info")
@NamedQuery(name = "fingById",query="select a from MakeupEntity a where a.productId=:id")
@NamedQuery(name = "getAllEntity",query = "select a from MakeupEntity a")






public class MakeupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "itemCount")
    private int itemCount;
}
