package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/workintech")
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    @GetMapping("/animal/{id}")
    public Animal findById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, new Animal(animal.getId(), animal.getName()));
        return animal;
    }

    @DeleteMapping("/animal/{id}")
    public Animal delete(@PathVariable int id) {
        Animal animal = animals.get(id);
        animals.remove(animal);
        return animal;
    }
}
