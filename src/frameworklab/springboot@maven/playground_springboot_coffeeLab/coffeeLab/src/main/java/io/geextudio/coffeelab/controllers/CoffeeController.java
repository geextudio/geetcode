package io.geextudio.coffeelab.controllers;

import io.geextudio.coffeelab.domains.Coffee;
import io.geextudio.coffeelab.repositories.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
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
    Iterable<Coffee> getCoffees() {
        return this.coffeeRepository.findAll();
    }

    @GetMapping("/{id}")//("/coffees/{id}")
    Optional<Coffee> getCoffee(@PathVariable String id) {
        return this.coffeeRepository.findById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id,
                                     @RequestBody Coffee updatedCoffee) {
        var saveResult = this.coffeeRepository.save(updatedCoffee);
        return this.coffeeRepository.existsById(id)?
                new ResponseEntity<Coffee>(saveResult, HttpStatus.OK)://200
                new ResponseEntity<Coffee>(saveResult, HttpStatus.CREATED);//201
    }

    @PostMapping//("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        if(coffee != null && !coffee.getName().isEmpty()){
            return this.coffeeRepository.save(coffee);
        }
        return new Coffee("", "");
    }

    @DeleteMapping("/{id}")//("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.coffeeRepository.deleteById(id);
    }
}
