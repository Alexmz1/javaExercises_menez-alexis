package fr.menez.myApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.menez.myApi.model.Animal;
import fr.menez.myApi.service.AnimalService;

@RestController
public class AnimalController {
    // Attribut
    private AnimalService animalService;

    // Constructeur
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Méthode
    // méthode GET
    @GetMapping("/animal")
    public Animal getAnimal(@RequestParam("id") int id){
        Animal animal = animalService.getAnimal(id);

        return animal;
    }

    // méthode POST
    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody AnimalRequest body){
        // On récupère les paramètres
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();
        Animal animal = animalService.createAnimal(name, type, weight);

        return animal;
    }

    // méthode UPDATE
    @PutMapping("/animal")
    public Animal updateAnimal(@RequestParam("id") int id, @RequestBody AnimalRequest body){
        // On récupère les paramètres
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();
        Animal animal = animalService.updateAnimal(id, name, type, weight);

        return animal;
    }

    // méthode DELETE
    @DeleteMapping("/animal")
    public Animal deleteAnimal(@RequestParam("id") int id){
        Animal animal = animalService.deleteAnimal(id);

        return animal;
    }

    // méthode GET pour récupérer la liste complète des animaux
}
