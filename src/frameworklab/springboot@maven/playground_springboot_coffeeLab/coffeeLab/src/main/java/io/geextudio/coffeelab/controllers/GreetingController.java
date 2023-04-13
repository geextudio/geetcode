package io.geextudio.coffeelab.controllers;

import io.geextudio.coffeelab.properties.GreetingInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
@Api(tags = "Greeting RESTful 接口")
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
    @ApiOperation(value = "获取接口名称")
    String getGreeting() {

        return greeting.getName();
    }

    @GetMapping("/coffee")
    @ApiOperation(value = "获取接口咖啡信息")
    String getCoffeeGreeting() {

        return greeting.getCoffee();
    }

    @GetMapping("/coffee/version")
    @ApiOperation(value = "获取接口版本")
    String getCoffeeVersion() {

        return greeting.getVersion();
    }


}
