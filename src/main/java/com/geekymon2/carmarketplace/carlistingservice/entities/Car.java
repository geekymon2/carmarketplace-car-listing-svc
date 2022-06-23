package com.geekymon2.carmarketplace.carlistingservice.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "make is mandatory")
    private String make;

    @NotBlank(message = "model is mandatory")
    private String model;
    private int year;
    private int doors;
    private int seats;
    private double price;
    private int odometer;
    private String description;
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
}