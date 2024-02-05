package com.greenhub.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TravelOption {
    private Travelers traveler;
    private Trip trip;

    public TravelOption(Travelers traveler, Trip trip ) {
        this.traveler = traveler;
        this.trip = trip;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public Travelers getTraveler() {
        return this.traveler;
    }

    public HashMap<Travelers, Trip> getTravelOption() {
        HashMap<Travelers, Trip> travelOption = new HashMap<>();
        travelOption.put(this.traveler,this.trip);
        return travelOption;
    }

    public int getCO2() {
        if (Objects.equals(trip.getModeOfTransport().getTransportName(), "Car")){
            return trip.getCo2();
        }
            return trip.getCo2()*traveler.getNumberOfTravelers();
    }

    public int getBudgetPerPerson () {
        if (trip.getModeOfTransport().getTransportName() == "Car"){
            return trip.getBudgetPerPerson();
        }
            return trip.getBudgetPerPerson()*traveler.getNumberOfTravelers();
        }

    public void print() {
        System.out.println("Détails de l'option de voyage :");
            for (Map.Entry<Travelers, Trip> entry : this.getTravelOption().entrySet()) {
                Travelers traveler = entry.getKey();
                Trip trip = entry.getValue();
                System.out.println("Voyageur : " + traveler.getName());
                System.out.println("Départ : " + trip.getDepartureCity().getName());
                System.out.println("Arrivée : " + trip.getArrivalCity().getName());
                System.out.println("Distance : " + trip.getDistance());
                System.out.println("CO2 généré (en kg): " + this.getCO2()/1000);
                System.out.println("Durée du trajet : " + trip.getTravelTime()/60 + "h" + trip.getTravelTime()%60);
                System.out.println("Mode de transport : " + trip.getModeOfTransport().getTransportName());
                System.out.println("-----");
            }
    }

    public String printToString() {
        StringBuilder result = new StringBuilder();
        result.append("Détails de l'option de voyage :\n");
        for (Map.Entry<Travelers, Trip> entry : this.getTravelOption().entrySet()) {
            Travelers traveler = entry.getKey();
            Trip trip = entry.getValue();
            result.append("Voyageur : ").append(traveler.getName()).append("\n");
            result.append("Départ : ").append(trip.getDepartureCity().getName()).append("\n");
            result.append("Arrivée : ").append(trip.getArrivalCity().getName()).append("\n");
            result.append("Distance : ").append(trip.getDistance()).append("\n");
            result.append("CO2 généré (en kg): ").append(this.getCO2() / 1000).append("\n");
            result.append("Durée du trajet : ").append(trip.getTravelTime() / 60).append("h").append(trip.getTravelTime() % 60).append("\n");
            result.append("Mode de transport : ").append(trip.getModeOfTransport().getTransportName()).append("\n");
            result.append("-----\n");
        }
        return result.toString();
    }

}
