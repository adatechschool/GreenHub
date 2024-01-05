package com.greenhub.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greenhub.models.City;
import com.greenhub.models.Trip;
import com.greenhub.repository.CityLoader;
import com.greenhub.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping("/planeTrip")
    public Trip fetchTrip(@RequestParam String origin, @RequestParam String destination) throws JsonProcessingException {
        City originCity = buildCityFromString(origin);
        City destinationCity = buildCityFromString(destination);

        return planeService.getPlaneTrip(originCity, destinationCity);
    }

    @GetMapping("/all")
    public ArrayList<Trip> fetchAllTrips(@RequestParam String origin) {
        City originCity = buildCityFromString(origin);
        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");
        return planeService.getAllPlaneTrips(originCity,destinations);
    }

    private City buildCityFromString(String string) {
        String[] values = string.split(";");
        String cityName = values[0];
        float cityX = Float.parseFloat(values[1]);
        float cityY = Float.parseFloat(values[2]);
        String iataCode = values[3];
        return new City(cityName, cityX, cityY, iataCode);
    }
}