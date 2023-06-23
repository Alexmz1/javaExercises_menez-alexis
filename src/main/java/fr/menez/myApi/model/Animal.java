package fr.menez.myApi.model;

public class Animal {
    // Attributs
    private int id;
    private String name;
    private String type;
    private int weight;
    
    // Constructeur
    public Animal(int id, String name, String type, int weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    } 
}
