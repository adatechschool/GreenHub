package com.greenhub.services;

import com.greenhub.models.City;
import com.greenhub.models.GlobalTravelOption;
import com.greenhub.models.TravelOption;
import com.greenhub.models.Travelers;
import com.greenhub.models.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BestTravelOptionService {

    public static GlobalTravelOption getLowestCo2Option(Travelers[] groupOfTravelers, City[] destinations) {
        //create an arrayList to store the best options for each destination
        ArrayList<GlobalTravelOption> possibleOptions = new ArrayList<>();
        for (City destination : destinations) {
            //Create an arraylist of travelOption which associate the travelers to a trip option
            ArrayList<TravelOption> bestOptionPerDestination = new ArrayList<>();
            for (Travelers traveler : groupOfTravelers) {
                //get the best option regarding CO2 for a traveler
                Trip bestOptionPerTravelerPerDestination = traveler.getBestOptionPerDestination(destination);
                //store it in a travelOption object and then in the bestOptionPerDestination array
                TravelOption travelOption = new TravelOption(traveler, bestOptionPerTravelerPerDestination);
                bestOptionPerDestination.add(travelOption);

            }
            boolean possibleDestination = true;
            for (TravelOption travelOption : bestOptionPerDestination) {
                if (travelOption.getTrip() == null) {
                    possibleDestination = false;
                    break;
                }
            }
            if (possibleDestination) {
                GlobalTravelOption globalTravelOption = new GlobalTravelOption(bestOptionPerDestination);
                possibleOptions.add(globalTravelOption);
            }
        }
        //loop into the possible options and keep the one with the lowest CO2 emission
        int minCO2 = Integer.MAX_VALUE; // Initialisation avec une valeur très élevée
        GlobalTravelOption bestOption = null;

        for (GlobalTravelOption option : possibleOptions) {
            int totalCO2 = 0;
            for (TravelOption travelOption : option.getGlobalTravelOption()) {
                totalCO2 += travelOption.getCO2();
            }
            if (totalCO2 < minCO2) {
                minCO2 = totalCO2;
                bestOption = option;
            }
        }
        return bestOption;
    }
}