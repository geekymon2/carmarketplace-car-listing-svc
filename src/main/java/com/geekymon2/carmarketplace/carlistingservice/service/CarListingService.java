package com.geekymon2.carmarketplace.carlistingservice.service;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;

import java.util.List;

public interface CarListingService {
    List<Car> getCars();
    Long AddCar(Car car);
    void UpdateCar(Car car);
}
