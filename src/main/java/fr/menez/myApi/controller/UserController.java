package fr.menez.myApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.menez.myApi.model.User;
import fr.menez.myApi.service.UserService;

@RestController
public class UserController {
    // Attribut
    private UserService userService;

    // Constructeur
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Méthode
    // Exercice 1
    @GetMapping("/user")    // /user est la partie a ajouter dans l'url
    public User getUser(@RequestParam("id") int id) {   // Création de la méthode getUser pour l'API
        User user = userService.getUsers(id);    // On rappelle la méthode getUsers initialisée dans UserService en y ajoutant comme paramètre l'id
                                                 // pour que celle ci nous écrive les infos de l'utilisateur en fct de l'id s'il y en a un
        return user;
    }

    // Exercice 2
    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest body) {     // On utilise la classe UserRequest pour recupérer les paramètres name et age
        // On récupère les paramètres
        String name = body.getName();
        int age = body.getAge();
        User user = userService.createUser(name, age);       // On retourne la méthode createUser initialisée dans la classe UserService

        return user;
    }

    // Exercice 3
    @PutMapping("/user")
    public User updateUser(@RequestParam("id") int id, @RequestBody UserRequest body){      // On utilise et la classe UserRequest pour recupérer les paramètres name et age
        // On récupère les paramètres
        String name = body.getName();
        int age = body.getAge();
        User user = userService.updateUser(id, name, age);       // On retourne la méthode updateUser initialisée dans la classe UserService

        return user;
    }

    // Exercice 4
    @DeleteMapping("/user")
    public User deleteUser(@RequestParam("id") int id){
        User user = userService.deleteUser(id);      // On retourne la méthode deleteUser initialisée dans la classe UserService

        return user;
    }
}