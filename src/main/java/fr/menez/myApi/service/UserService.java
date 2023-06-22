package fr.menez.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.menez.myApi.model.User;

@Service
public class UserService {
    // Attribut
    private ArrayList<User> users;

    // Constructeur
    public UserService(){
        this.users = new ArrayList<>();
        
        // Ajout des différents utilisateurs
        this.users.add(new User(1, "Alexis", 21));
        this.users.add(new User(2, "Marie", 40));
        this.users.add(new User(3, "Kylian", 24));
    }

    // Méthode
    public User getUsers(int id){       // Nom de la méthode avec les paramètres a utiliser
        for (User user : this.users) {       // Boucle foreach
            if (user.getId() == id) {   // qui vérifie si un user possède un id
                return user;            // Si oui = retourne les infos du user
            }
        }
        return null;                    // Si non = ne retourne rien
    }

    public User createUser(String name, int age){
        User user = new User(users.size() + 1, name, age);
        
        users.add(user);
        return user;
    }
}
