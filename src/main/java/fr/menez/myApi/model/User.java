package fr.menez.myApi.model;

public class User {
    // Attributs
    private int id;
    private String name;
    private int age;

    // Constructeur
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
