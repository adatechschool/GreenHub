package com.greenhub.models;

public class City {

    private String name;
    private float x;
    private float y;
    private String iataCode;

    // constructeur
    public City(String name, float x, float y, String iataCode) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.iataCode = iataCode;
    }

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

    public String getIataCode() {
        return this.iataCode;
    }

    public String coordinatesAsString() {
        return getY() + ";" + getX();
    }

}
