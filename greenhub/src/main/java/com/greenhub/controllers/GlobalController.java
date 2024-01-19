package com.greenhub.controllers;


import com.greenhub.models.City;
import com.greenhub.models.GlobalTravelOption;
import com.greenhub.models.Travelers;
import com.greenhub.models.Trip;
import com.greenhub.repository.CityLoader;
import com.greenhub.repository.DataRepository;
import com.greenhub.services.BestTravelOptionService;
import com.greenhub.services.PlaneService;
import com.greenhub.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/bestoption")
public class GlobalController {

    private final PlaneService planeService;
    private final TrainService trainService;


    @Autowired
    public GlobalController(PlaneService planeService, TrainService trainService) {
        this.planeService = planeService;
        this.trainService = trainService;
    }

    @GetMapping("/test")
    public ArrayList<GlobalTravelOption> getBestOption() {
        int maxTravelTime = 240;
        Travelers traveler1 = new Travelers("Nantais", buildCityFromString("Nantes,47.2176116889171,-1.5412401068009252,NTE"), 4, maxTravelTime, 1000);
        Travelers traveler2 = new Travelers("Lyonnais", buildCityFromString("Lyon,45.76606462763691,4.83272363442929,LYS"), 5, maxTravelTime, 1000);
        Travelers traveler3 = new Travelers("Parisiens", buildCityFromString("Paris,48.84110341748926,2.3220227046059105,CDG"), 2, maxTravelTime, 1000);
        Travelers traveler4 = new Travelers("Bordelais", buildCityFromString("Bordeaux,44.82529325038888,-0.5562017943285817,BOD"), 2, maxTravelTime, 1000);
        Travelers traveler5 = new Travelers("Toulousains", buildCityFromString("Toulouse,43.61133885593007,1.4543164961156636,TLS"), 3, maxTravelTime, 1000);

        Travelers[] groupOfTravelers = {traveler1, traveler2, traveler4, traveler5};
        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");
        ArrayList<Trip> allTrips = new ArrayList<>();
        for (Travelers traveler : groupOfTravelers) {
            Collection<Trip> planeTrips = planeService.getAllPlaneTrips(traveler.getLivingCity(), destinations);
            Collection<Trip> trainTrips = trainService.getAllTrainTrips(traveler.getLivingCity(), destinations);
            allTrips.addAll(planeTrips);
            allTrips.addAll(trainTrips);
        }
        ArrayList<GlobalTravelOption> bestOptions = BestTravelOptionService.getLowestCo2Option(groupOfTravelers, destinations, allTrips);
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