package com.iths.labb2.entities;

import javax.persistence.*;


@Entity
@Table(name = "snake")

public class Snake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private double weight;
    private String gender;


    public Snake(int id,String name, String type, double weight, String gender) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.gender = gender;
    }

    public Snake() {

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

