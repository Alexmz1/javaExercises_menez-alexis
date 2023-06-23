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
    // Exercice 1
    public User getUsers(int id){       // Nom de la méthode avec les paramètres a utiliser
        for (User user : this.users) {  // Boucle foreach
            if (user.getId() == id) {   // Vérifie si un user possède un id
                return user;            // Si oui = retourne les infos du user
            }
        }
        return null;                    // Si non = ne retourne rien
    }

    // Exercice 2
    public User createUser(String name, int age){
        User user = new User(users.size() + 1, name, age);  // L'id du nouveau user s'auto incremente de +1 et on récupère le nom et prenom rentré (si l'id commence a 0, on a pas besoin d'ajouter le +1)
        users.add(user);    // On ajoute le nouveau user à notre tableau ArrayList
        return user;        // On retourne le user
    }

    // Exercice 3
    public User updateUser(int id, String name, int age){
        for (User user : this.users) {      // Boucle foreach
            if (user.getId() == id) {       // Vérifie si un user possède un id
                user.setName(name);         // Modifier la valeur name grace au setter setName
                user.setAge(age);           // Modifier la valeur age grace au setter setAge
                return user;                // On retourne le user
            }
        }
        return null;
    }

    // Exercice 4
    public User deleteUser(int id){
        for (User user : this.users) {              // Boucle foreach
            if (user.getId() == id) {               // Pour parcourir les id dans le tableau et vérifier s'il on en trouve un identique à celui demandé
                int index = this.users.indexOf(user);    // On prend en paramètre "index" avec la méthode indexOf qui retourne l'index du user du tableau
                return this.users.remove(index);         // On supprime le user associé à l'index
            }
        }
        return null;
    }
}
