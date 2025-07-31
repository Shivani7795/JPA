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
@Table(name = "event_registration")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "registered_on")
    private String registeredOn;

    @Column(name = "college_name")
    private String collegeName;
}
