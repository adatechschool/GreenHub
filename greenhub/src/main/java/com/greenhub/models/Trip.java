package com.greenhub.models;
import java.lang.Math;


public class Trip {
    private City departureCity;
    private City arrivalCity;
    private int distance;
    private int travelTime;
    private int budgetPerPerson;
    private ModeOfTransport modeOfTransport;

    // Constructeur
    public Trip(City departureCity, City arrivalCity, int distance, ModeOfTransport modeOfTransport, int travelTime, int budgetPerPerson) {
        // qd on aura des coordonnes changer le param distance en une méthode getDistance qui calculera la d selon les coord.
        // les
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distance = distance;
        this.modeOfTransport = modeOfTransport;
        switch(this.modeOfTransport.getTransportName()) {
            case "Train":
                this.travelTime = travelTime;
                break;
            case "Plane":
                this.travelTime = travelTime + 120;
                break;
            case "Car":
                this.travelTime = travelTime;
                break;
            default:
                System.out.println("Not a valid mode of transport");

        }
        this.budgetPerPerson = budgetPerPerson;
    }

    public City getDepartureCity() {
        return this.departureCity;
    }
    public City getArrivalCity() {
        return this.arrivalCity;
    }
    public int getDistance() {
        return this.distance;
    }

    public ModeOfTransport getModeOfTransport() {
        return this.modeOfTransport;
    }

    public int getBudgetPerPerson () { return this.budgetPerPerson;};
    public int getTravelTime () { return this.travelTime;};

    public int calculateCo2(){
        return Math.round(this.distance * this.modeOfTransport.getCO2PerKilometer() / 1000);
    };


}

