package io.geextudio.coffeelab.controllers;

import io.geextudio.coffeelab.properties.GreetingInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
//    @Value("${greeting-name: Mirage}")
//    private String name;
//
//    @Value("${greeting-coffee: ${greeting-name} likes tea as default}")
//    private String coffeeMessage;

    private final GreetingInfo greeting;

    public GreetingController (GreetingInfo greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    String getGreeting() {

        return greeting.getName();
    }

    @GetMapping("/coffee")
    String getCoffeeGreeting() {

        return greeting.getCoffee();
    }

    @GetMapping("/coffee/version")
    String getCoffeeVersion() {

        return greeting.getVersion();
    }


}
