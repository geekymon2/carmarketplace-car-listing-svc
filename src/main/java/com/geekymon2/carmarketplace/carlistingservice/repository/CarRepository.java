package com.geekymon2.carmarketplace.carlistingservice.repository;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}