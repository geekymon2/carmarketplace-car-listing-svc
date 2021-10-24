package com.geekymon2.carmarketplace.carlistingservice.validation;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import com.geekymon2.carmarketplace.core.entities.CarMakeName;
import com.geekymon2.carmarketplace.core.exception.InvalidParameterException;

public class CarListingValidator {

    public void validateCar(Car car) {

        try {
            CarMakeName.valueOf(car.getMake());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidParameterException(String.format("Invalid make '%s'", car.getMake()));
        }
    }
}
