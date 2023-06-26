package fr.menez.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.menez.myApi.model.Animal;

@Service
public class AnimalService {
    // Attribut
    private ArrayList<Animal> animals;

    // Constructeur
    public AnimalService(){
        this.animals = new ArrayList<>();
        
        // Ajout des différents utilisateurs
        this.animals.add(new Animal(1, "Lion", "Mammifère", 190));
        this.animals.add(new Animal(2, "Cheval", "Mammifère", 700));
        this.animals.add(new Animal(3, "Tortue", "Reptile", 2));
    }

    // Méthodes
    // méthode GET
    public Animal getAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    // méthode POST(create)
    public Animal createAnimal(String name, String type, int weight) {
        Animal animal = new Animal(animals.size() + 1, name, type, weight);
        animals.add(animal);

        return animal;
    }
    
    // méthode UPDATE
    public Animal updateAnimal(int id, String name, String type, int weight) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                animal.setName(name);
                animal.setType(type);
                animal.setWeight(weight);
                return animal;
            }
        }
        return null;
    }

    // méthode DELETE
    public Animal deleteAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                int index = this.animals.indexOf(animal);
                return this.animals.remove(index);
            }
        }
        return null;
    }

    // méthode GET pour récupérer la liste complète des animaux
    public ArrayList<Animal> getAllAnimal() {
        return animals;
    }
}
