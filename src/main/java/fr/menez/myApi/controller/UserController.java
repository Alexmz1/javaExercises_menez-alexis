package fr.menez.myApi.controller;

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
        return userService.getUsers(id);    // On rappelle la méthode getUsers initialisée dans UserService en y ajoutant comme paramètre l'id
    }                                       // pour que celle ci nous écrive les infos de l'utilisateur en fct de l'id s'il y en a un

    // Exercice 2
    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest body) {     // On utilise la classe UserRequest pour recupérer les paramètres name et age
        // On récupère les paramètres
        String name = body.getName();
        int age = body.getAge();
        return userService.createUser(name, age);       // On retourne la méthode createUser initialisée dans la classe UserService
    }

    // Exercice 3
    @PutMapping("/user")
    public User updateUser(@RequestParam("id") int id, @RequestBody UserRequest body){      // On utilise et la classe UserRequest pour recupérer les paramètres name et age
        // On récupère les paramètres
        String name = body.getName();
        int age = body.getAge();
        return userService.updateUser(id, name, age);       // On retourne la méthode updateUser initialisée dans la classe UserService
    }
}