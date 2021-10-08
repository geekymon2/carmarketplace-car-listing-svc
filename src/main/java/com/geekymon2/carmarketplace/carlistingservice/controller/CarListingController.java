package com.geekymon2.carmarketplace.carlistingservice.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.geekymon2.carmarketplace.carlistingservice.entities.Car;
import com.geekymon2.carmarketplace.carlistingservice.models.CarDto;
import com.geekymon2.carmarketplace.carlistingservice.models.StatusDto;
import com.geekymon2.carmarketplace.carlistingservice.serviceimpl.CarListingServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

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
        String hostname = "";
        String environment = "";
        String version = "0.0.0";

        try {
            log.info("Performing status check.");
            hostname = java.net.InetAddress.getLocalHost().getHostName();
            environment = System.getenv("ENVIRONMENT");
            version = Files.readString(Paths.get("/version.properties")).split("=")[1];
        }
        catch (UnknownHostException uhx) {
            hostname = UNKNOWN_LABEL;
            log.error(String.format("Error getting hostname: %s", uhx));
        }
        catch (IOException iox) {
            version = UNKNOWN_LABEL;
            log.error(String.format("Error getting version: %s", iox));
        }

        return new StatusDto(environment, version, hostname);
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
    public Long addCar(@Valid CarDto carDto) {
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