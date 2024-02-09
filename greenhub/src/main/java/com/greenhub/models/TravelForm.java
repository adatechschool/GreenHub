package com.greenhub.models;

public class TravelForm {
    private String name;
    private String livingCityName;
    private float livingCityX;
    private float livingCityY;
    private String livingCityIataCode;
    private int numberOfTravelers;
    private int maxTravelTime;
    private int maxBudgetPerPerson;

    public int getMaxBudgetPerPerson() {
        return maxBudgetPerPerson;
    }

    public int getMaxTravelTime() {
        return maxTravelTime;
    }

    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }

    public String getLivingCityIataCode() {
        return livingCityIataCode;
    }

    public float getLivingCityY() {
        return livingCityY;
    }

    public float getLivingCityX() {
        return livingCityX;
    }

    public String getLivingCityName() {
        return livingCityName;
    }

    public String getName() {
        return name;
    }


}