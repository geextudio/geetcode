package io.geextudio.coffeelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.UUID;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CoffeeLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeLabApplication.class, args);
    }

}

