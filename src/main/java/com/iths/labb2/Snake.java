package com.iths.labb2;

import javax.persistence.*;


@Entity
@Table(name = "snakes")

public class Snake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private double weight;
    private String gender;


    public Snake(String name, String type, double weight, String gender) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.gender = gender;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }
}

