package com.greenhub.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greenhub.models.City;
import com.greenhub.models.Trip;
import com.greenhub.services.CityLoader;
import com.greenhub.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/trainTrip")
    public Trip fetchTrip(@RequestParam String origin, @RequestParam String destination) throws JsonProcessingException {
        City originCity = buildCityFromCoordinates(origin);
        City destinationCity = buildCityFromCoordinates(destination);

        return trainService.getTrainTrip(originCity, destinationCity);
    }

    @GetMapping("/all")
    public ArrayList<Trip> fetchAllTrips(@RequestParam String origin) {
        City originCity = buildCityFromCoordinates(origin);
        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");
        return trainService.getAllTrainTrips(originCity,destinations);
    }

    private City buildCityFromCoordinates(String coordinates) {
        String[] values = coordinates.split(",");
        String cityName = values[0];
        float cityX = Float.parseFloat(values[1]);
        float cityY = Float.parseFloat(values[2]);
        return new City(cityName, cityX, cityY);
    }
}
