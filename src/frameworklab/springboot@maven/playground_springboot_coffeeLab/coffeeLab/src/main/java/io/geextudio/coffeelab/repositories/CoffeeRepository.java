package io.geextudio.coffeelab.repositories;

import io.geextudio.coffeelab.domains.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository  extends CrudRepository<Coffee, String> { }
