package com.geekymon2.carmarketplace.carlistingservice.controller;

import com.geekymon2.carmarketplace.carlistingservice.models.StatusDto;
import com.geekymon2.carmarketplace.carlistingservice.serviceimpl.CarListingServiceImpl;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.SneakyThrows;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;

@SpringBootTest
class CarListingControllerTest {
    private final CarListingController controller;

    @Autowired
    public CarListingControllerTest(CarListingServiceImpl service, ModelMapper mapper) {
        this.controller = new CarListingController(service, mapper);
    }    

    @SneakyThrows
    @Test
    @DisplayName("Test status endpoint.")
    void getStatus() {
        StatusDto status = controller.getStatus();
        assertThat(status.getHostname().equals(java.net.InetAddress.getLocalHost().getHostName())).isTrue();
    }
}