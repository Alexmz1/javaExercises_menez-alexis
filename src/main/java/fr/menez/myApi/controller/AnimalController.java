package fr.menez.myApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Animal> getAnimal(@RequestParam("id") int id){
        Animal animal = animalService.getAnimal(id);
        
        if (animal != null) {
            return ResponseEntity.ok(animal); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // méthode POST
    @PostMapping("/animal")
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalRequest body){
        // On récupère les paramètres
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();
        Animal animal = animalService.createAnimal(name, type, weight);

        return ResponseEntity.status(HttpStatus.CREATED).body(animal); // 201 Created
    }

    // méthode UPDATE
    @PutMapping("/animal")
    public ResponseEntity<Animal> updateAnimal(@RequestParam("id") int id, @RequestBody AnimalRequest body){
        // On récupère les paramètres
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();
        Animal animal = animalService.updateAnimal(id, name, type, weight);

        if (animal != null) {
            return ResponseEntity.ok(animal); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // méthode DELETE
    @DeleteMapping("/animal")
    public ResponseEntity<Animal> deleteAnimal(@RequestParam("id") int id){
        Animal animal = animalService.deleteAnimal(id);

        if (animal != null) {
            return ResponseEntity.ok(animal); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // méthode GET pour récupérer la liste complète des animaux
    @GetMapping("/animals")
    public List<Animal> getAllAnimal() {
        List<Animal> animals = animalService.getAllAnimal();
        return animals;
    }
}
