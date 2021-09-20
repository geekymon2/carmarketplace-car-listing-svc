package com.geekymon2.carmarketplace.carlistingservice.controller;

import com.geekymon2.carmarketplace.carlistingservice.serviceimpl.CarListingServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/car")
public class CarListingController {

    private final CarListingServiceImpl service;
    private final ModelMapper mapper;

    public CarListingController(CarListingServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }    
    
}
