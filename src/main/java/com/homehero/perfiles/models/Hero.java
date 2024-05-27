package com.homehero.perfiles.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
    private int id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 320)
    private String email;

    @Column(nullable = false, length = 10)
    private String identification;

    @Column(nullable = false, length = 120)
    private String job;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 150)
    private String neighborhood;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false)
    private String image_url;

    @Column(nullable = false, length = 15)
    private String work_days;

    @Column(nullable = false)
    private int init_hour;

    @Column(nullable = false)
    private int end_hour;

}

