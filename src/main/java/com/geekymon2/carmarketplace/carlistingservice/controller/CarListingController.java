package com.geekymon2.carmarketplace.carlistingservice.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.geekymon2.carmarketplace.carlistingservice.models.StatusDto;
import com.geekymon2.carmarketplace.carlistingservice.serviceimpl.CarListingServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
