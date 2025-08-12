package com.xworkz.tourism.entity;

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
@Table(name = "tourism_info")
@NamedQuery(name = "findBy",query = "select a from ApplicationEntity a where a.applicationName=:name")

public class TourismEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packageId")
    private Integer packageId;

    @Column(name = "packageName")
    private String packageName;

    @Column(name = "destination")
    private String destination;

    @Column(name = "days")
    private Integer days;

    @Column(name = "packagePrice")
    private Double packagePrice;

    @Column(name = "personCount")
    private Integer personCount;
}
