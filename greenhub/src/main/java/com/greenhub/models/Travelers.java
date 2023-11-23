package com.greenhub.models;

import com.greenhub.Main;

import java.util.ArrayList;


public class Travelers {

    private String travelersName;
    private City livingCity;
    private int numberOfTravelers;
    private int maxTravelTime;
    private int maxBudgetPerPerson;



    // Constructeur
    public Travelers(String travelersName, City livingCity,int numberOfTravelers, int maxTravelTime, int maxBudgetPerPerson) {
        this.travelersName = travelersName;
        this.livingCity = livingCity;
        this.numberOfTravelers = numberOfTravelers;
        this.maxTravelTime = maxTravelTime;
        this.maxBudgetPerPerson = maxBudgetPerPerson;
    }

    public String getName() {
        return travelersName;
    }
    public City getLivingCity() {
        return livingCity;
    }
    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }

    public ArrayList<Trip> getPossibleOptionsPerDestination (City destination) {
        //Create an arraylist to store the possible options for the destination
        ArrayList<Trip> possibleOptions = new ArrayList<>();
        //loop into all the trips and add the relevant elements to the arraylist
        for (Trip trip: Main.allTrips) {
            if (this.livingCity == trip.getDepartureCity()
                    && trip.getArrivalCity() == destination
                    && trip.getTravelTime() <= this.maxTravelTime
                    && trip.getBudgetPerPerson() <= this.maxBudgetPerPerson) {
                possibleOptions.add(trip);
            }
        }
        //return the arraylist
        return possibleOptions;
    }

    public Trip getBestOptionPerDestination (City destination) {
        //Create an arraylist to store the possible options for the destination
        ArrayList<Trip> possibleOptions = this.getPossibleOptionsPerDestination(destination);
        //loop into the possible options and keep the one with the lowest CO2 emission
        if (possibleOptions.size()==0) {
            return null;
        }
        int minCO2 = possibleOptions.get(0).calculateCo2()*this.numberOfTravelers;
        Trip bestOption = possibleOptions.get(0);
        for (int i=1; i<possibleOptions.size(); i++) {
            if(possibleOptions.get(i).calculateCo2() < minCO2) {
                minCO2 = possibleOptions.get(i).calculateCo2()*this.numberOfTravelers;
                bestOption = possibleOptions.get(i);
            }
        }
        //return the best option
        return bestOption;
    }
}

