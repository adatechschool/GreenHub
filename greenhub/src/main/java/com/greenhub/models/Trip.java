package com.greenhub.models;
import java.lang.Math;


public class Trip {
    private City departureCity;
    private City arrivalCity;
    private int distance;
    private int travelTime;
    private int budgetPerPerson;
    private ModeOfTransport modeOfTransport;
    private int co2;

    // Constructeur
    public Trip(City departureCity, City arrivalCity, int distance, ModeOfTransport modeOfTransport, int travelTime, int budgetPerPerson, int co2) {
        // qd on aura des coordonnes changer le param distance en une méthode getDistance qui calculera la d selon les coord.
        // les
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distance = distance;
        this.modeOfTransport = modeOfTransport;
        this.travelTime = travelTime + modeOfTransport.overtime();
        this.budgetPerPerson = budgetPerPerson;
        this.co2 = co2;
    }

    public Trip(City departureCity, City arrivalCity, int distance, ModeOfTransport modeOfTransport, int travelTime, int budgetPerPerson) {
        // qd on aura des coordonnes changer le param distance en une méthode getDistance qui calculera la d selon les coord.
        // les
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distance = distance;
        this.modeOfTransport = modeOfTransport;
        this.travelTime = travelTime + modeOfTransport.overtime();
        this.budgetPerPerson = budgetPerPerson;
        this.co2 = Math.round(this.distance * this.modeOfTransport.getCO2PerKilometer() / 1000);
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

    public int getCo2(){
        return this.co2;
    };


}

