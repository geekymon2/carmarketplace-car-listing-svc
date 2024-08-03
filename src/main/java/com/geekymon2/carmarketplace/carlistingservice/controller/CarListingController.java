package com.geekymon2.carmarketplace.carlistingservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import com.geekymon2.carmarketplace.carlistingservice.models.CarDto;
import com.geekymon2.carmarketplace.carlistingservice.serviceimpl.CarListingServiceImpl;

import com.geekymon2.carmarketplace.core.common.ApiStatus;
import com.geekymon2.carmarketplace.core.models.StatusDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/carlisting")
public class CarListingController {

    private final CarListingServiceImpl service;
    private final ModelMapper mapper;
    private final String UNKNOWN_LABEL = "unknown";

    public CarListingController(CarListingServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/status")
    public StatusDto getStatus() {
        return new ApiStatus().getStatus();
    }

    @GetMapping(value = "/cars")
    public List<CarDto> getCars() {
        return service.getCars().stream().map(this::carToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/cars/count")
    public Long getCarsCount() {
        return service.getCarsCount();
    }

    @PostMapping(value = "/car")
    public Long addCar(CarDto carDto) {
        Car car = mapper.map(carDto, Car.class);
        return service.addCar(car);
    }

    @PutMapping(value = "/car")
    public void updateCar(CarDto carDto) {
        service.updateCar(mapper.map(carDto, Car.class));
    }

    private CarDto carToDto(Car car) {
        return mapper.map(car, CarDto.class);
    }
}