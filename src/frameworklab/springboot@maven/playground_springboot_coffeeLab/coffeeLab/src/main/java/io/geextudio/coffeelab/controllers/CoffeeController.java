package io.geextudio.coffeelab.controllers;

import io.geextudio.coffeelab.domains.Coffee;
import io.geextudio.coffeelab.repositories.CoffeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
@Api(tags = "Coffee RESTful 接口")
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;

    public CoffeeController (CoffeeRepository coffeeRepository) {

        this.coffeeRepository = coffeeRepository;

        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Cereza", "Taste from Europe"),
                new Coffee("Cafe Deliecoso", "Taste from South Asia"),
                new Coffee("Cafe Escanocia", "Taste from Africa"),
                new Coffee("Cafe Finaboch", "Taste from ")
        ));
    }

    @GetMapping//("/coffees")
    @ApiOperation(value = "获取所有咖啡信息")
    Iterable<Coffee> getCoffees() {
        return this.coffeeRepository.findAll();
    }

    @GetMapping("/{id}")//("/coffees/{id}")
    @ApiOperation(value = "获取指定咖啡信息")
    Optional<Coffee> getCoffee(@PathVariable String id) {
        return this.coffeeRepository.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新指定咖啡信息")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id,
                                     @RequestBody Coffee updatedCoffee) {
        var saveResult = this.coffeeRepository.save(updatedCoffee);
        return this.coffeeRepository.existsById(id)?
                new ResponseEntity<Coffee>(saveResult, HttpStatus.OK)://200
                new ResponseEntity<Coffee>(saveResult, HttpStatus.CREATED);//201
    }

    @PostMapping//("/coffees")
    @ApiOperation(value = "添加咖啡信息")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        if(coffee != null && !coffee.getName().isEmpty()){
            return this.coffeeRepository.save(coffee);
        }
        return new Coffee("", "");
    }

    @DeleteMapping("/{id}")//("/coffees/{id}")
    @ApiOperation(value = "删除咖啡信息")
    void deleteCoffee(@PathVariable String id) {
        this.coffeeRepository.deleteById(id);
    }
}
