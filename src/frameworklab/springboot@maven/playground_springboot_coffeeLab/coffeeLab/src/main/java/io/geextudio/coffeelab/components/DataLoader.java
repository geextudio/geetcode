package io.geextudio.coffeelab.components;

import io.geextudio.coffeelab.domains.Coffee;
import io.geextudio.coffeelab.repositories.CoffeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader (CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Cereza Component", "Taste from Europe"),
                new Coffee("Cafe Deliecoso Component", "Taste from South Asia"),
                new Coffee("Cafe Escanocia Component", "Taste from Africa"),
                new Coffee("Cafe Finaboch Component", "Taste from ")
        ));
    }
}
