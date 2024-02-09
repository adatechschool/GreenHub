package com.greenhub.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.greenhub.models.*;
import com.greenhub.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TravelFormController {

    private final PlaneService planeService;
    private final TrainService trainService;
    private final CarService carService;

    @Autowired
    public TravelFormController(PlaneService planeService, TrainService trainService, CarService carService) {
        this.planeService = planeService;
        this.trainService = trainService;
        this.carService = carService;
    }

    @PostMapping("/post")
    public ArrayList<GlobalTravelOption> createTravelers(@RequestBody TravelForm[] travelForms) throws JsonProcessingException {

        ArrayList<Travelers> travelers = new ArrayList<>();
        int maxTravelTime = 300;

        for (TravelForm travelForm : travelForms) {
            City city = new City(
                    travelForm.getLivingCityName(),
                    travelForm.getLivingCityX(),
                    travelForm.getLivingCityY(),
                    travelForm.getLivingCityIataCode()
            );

            Travelers traveler = new Travelers(
                    travelForm.getName(),
                    city,
                    travelForm.getNumberOfTravelers(),
                    travelForm.getMaxTravelTime(),
                    travelForm.getMaxBudgetPerPerson()
            );

            travelers.add(traveler);
        }

        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");

        ArrayList<Trip> allTrips = new ArrayList<>();
        for (City destination : destinations) {
            boolean destinationHasOption = true;

            for (Travelers traveler : travelers) {
                if (destinationHasOption) {
                    // call to train service
                    Trip trainTrip = trainService.getTrainTrip(traveler.getLivingCity(), destination);
                    // add the train trip if it exists and the travel time is valid
                    if (trainTrip != null && trainTrip.getTravelTime() < maxTravelTime) {
                        allTrips.add(trainTrip);
                    }

                    else {
                        // estimate the distance between the two cities
                        int distance = (int) DistanceCalculator.calculateDistance(traveler.getLivingCity(), destination);
                        // check if a car trip should be possible regarding distance, max speed and max travel time
                        if (distance < maxTravelTime * 110 / 60) {
                            // call to car service
                            Trip carTrip = carService.getCarTrip(traveler.getLivingCity(), destination);
                            // add the car trip if it exists and the travel time is valid
                            if (carTrip != null && carTrip.getTravelTime() < maxTravelTime) {
                                allTrips.add(carTrip);
                                //if a car trip is possible, call the plane service only if nb of travelers < 3
                                if (traveler.getNumberOfTravelers() < 3) {
                                    // call to plane service
                                    Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                                    // add the plane trip if it exists and the travel time is valid
                                    if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                        allTrips.add(planeTrip);
                                    }
                                }
                            }
                            else {
                                // call to plane service
                                Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                                // add the plane trip if it exists and the travel time is valid
                                if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                    allTrips.add(planeTrip);
                                }
                                if (planeTrip == null) {
                                    destinationHasOption = false;
                                }
                            }
                        }
                        else {
                            // call to plane service
                            Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                            // add the plane trip if it exists and the travel time is valid
                            if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                allTrips.add(planeTrip);
                            }
                            if (planeTrip == null) {
                                destinationHasOption = false;
                            }
                        }
                    }
                }
            }

        }

        ArrayList<GlobalTravelOption> bestOptions = BestTravelOptionService.getLowestCo2Option(travelers, destinations, allTrips);

        // Afficher les informations sur les meilleures options dans la console
        System.out.println("Top 5 meilleures destinations :");
        int count = Math.min(bestOptions.size(), 5); // Prendre les 3 premières, ou moins si moins de 3 options
        for (int i = 0; i < count; i++) {
            GlobalTravelOption option = bestOptions.get(i);
            System.out.println("Destination " + (i + 1) + ": " + option.getDestination() +
                    " - Émission de CO2 (en kg): " + option.getCO2Quantity() / 1000);
        }
        System.out.println("-----");

        if (!bestOptions.isEmpty()) {
            for (int i = 0; i < count; i++) {
                bestOptions.get(i).print();
            }
        } else {
            System.out.println("Aucune option de voyage trouvée pour le groupe.");
        }

        return bestOptions;

    }

    private City buildCityFromString(String string) {
        String[] values = string.split(",");
        String cityName = values[0];
        float cityX = Float.parseFloat(values[1]);
        float cityY = Float.parseFloat(values[2]);
        String iataCode = values[3];
        return new City(cityName, cityX, cityY, iataCode);
    }
}