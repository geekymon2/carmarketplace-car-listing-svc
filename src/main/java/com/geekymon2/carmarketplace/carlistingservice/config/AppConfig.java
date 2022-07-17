package com.geekymon2.carmarketplace.carlistingservice.config;

import com.geekymon2.carmarketplace.carlistingservice.validation.CarListingValidator;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Car Listing Service")
                        .description("Car Listing Service API")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Car Listing Service Documentation"));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CarListingValidator validator() {
        return new CarListingValidator();
    }      
}
