package com.greenhub.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GlobalTravelOption {
    private ArrayList<TravelOption> globalTravelOption;

    public GlobalTravelOption(ArrayList<TravelOption> globalTravelOption ) {
        this.globalTravelOption = globalTravelOption;
    }

    public int getCO2Quantity() {
        int CO2quantity = 0;
        for (TravelOption travelOption : this.globalTravelOption) {
            CO2quantity += travelOption.getCO2();
        }
        return CO2quantity;
    }

    public String getDestination() {
        return globalTravelOption.get(0).getTrip().getArrivalCity().getName();
    }

    public ArrayList<TravelOption> getGlobalTravelOption() {
        return this.globalTravelOption;
    }

    public void print() {
        System.out.println("Ville: " + this.getDestination());
        System.out.println("CO2 généré au total (en kg): " + this.getCO2Quantity()/1000);
        System.out.println("Détails de l'option de voyage pour tous les voyageurs:");
        for (TravelOption travelOption : this.globalTravelOption) {
           travelOption.print();
        }
    }

    public String printToString() {
        StringBuilder result = new StringBuilder();
        result.append("Ville: ").append(globalTravelOption.get(0).getTrip().getArrivalCity().getName()).append("\n");
        result.append("CO2 généré au total (en kg): ").append(this.getCO2Quantity() / 1000).append("\n");
        result.append("Détails de l'option de voyage pour tous les voyageurs:\n");
        for (TravelOption travelOption : this.globalTravelOption) {
            result.append(travelOption.printToString()).append("\n");
        }
        return result.toString();
    }


}

