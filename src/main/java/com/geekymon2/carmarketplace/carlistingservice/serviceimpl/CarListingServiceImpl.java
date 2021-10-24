package com.geekymon2.carmarketplace.carlistingservice.serviceimpl;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import com.geekymon2.carmarketplace.carlistingservice.repository.CarRepository;
import com.geekymon2.carmarketplace.carlistingservice.service.CarListingService;
import com.geekymon2.carmarketplace.carlistingservice.validation.CarListingValidator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarListingServiceImpl implements CarListingService {

    private final CarRepository carRepository;
    private final CarListingValidator validator;

    public CarListingServiceImpl(CarRepository carRepository, CarListingValidator validator) {
        this.carRepository = carRepository;
        this.validator = validator;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Long addCar(Car car) {
        validator.validateCar(car);
        return carRepository.save(car).getId();
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Long getCarsCount() {
        return carRepository.count();
    }
}
