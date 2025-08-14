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
@NamedQuery(name = "findById",query = "select a from TourismEntity a where a.packageId=:id")
@NamedQuery(name = "getAllEntity",query = "select a from TourismEntity a")
@NamedQuery(name = "update",query = "update TourismEntity e set e.packageName=:packageName,e.destination=:destination, e.days=:days,e.packagePrice=:packagePrice,e.personCount=:personCount where e.packageId=:packageId")

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
