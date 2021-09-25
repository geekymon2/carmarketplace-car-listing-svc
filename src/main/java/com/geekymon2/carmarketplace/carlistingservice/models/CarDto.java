package com.geekymon2.carmarketplace.carlistingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long id;
    private String make;
    private String model;
    private int year;
    private int doors;
    private int seats;
    private double price;
    private int odometer;
    private String description;
    private String bodyType;
    private String transmission;
}