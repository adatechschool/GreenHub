package com.greenhub.models;

public class City {

    private String name;
    private float x;
    private float y;

    // constructeur
    public City(String name, float x, float y) {

        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
