package com.geekymon2.carmarketplace.carlistingservice.serviceimpl;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import com.geekymon2.carmarketplace.carlistingservice.repository.CarRepository;
import com.geekymon2.carmarketplace.carlistingservice.service.CarListingService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarListingServiceImpl implements CarListingService {

    private final CarRepository carRepository;

    public CarListingServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public void AddCar() {

    }

    @Override
    public void UpdateCar() {

    }
}
