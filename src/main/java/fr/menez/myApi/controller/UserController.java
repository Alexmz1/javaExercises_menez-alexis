package fr.menez.myApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/user")    // /user est la partie a ajouter dans l'url
    public User getUser(@RequestParam("id") int id) {   // Création de la méthode getUser pour l'API
        return userService.getUsers(id);    // On rappelle la méthode getUsers initialisée dans UserService en y ajoutant comme paramètre l'id
    }                                       // pour que celle ci nous écrive les infos de l'utilisateur en fct de l'id s'il y en a un

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest body) {
        String name = body.getName();
        int age = body.getAge();
        return userService.createUser(name, age);
    }
}