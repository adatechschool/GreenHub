package com.greenhub.controllers;
import com.greenhub.models.City;
import com.greenhub.models.Trip;
import com.greenhub.repository.CityLoader;
import com.greenhub.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController // to use a REST api
@RequestMapping("/cars") // mapping corresponding to the CarController class
public class CarController {

    private final CarService carService;

    @Autowired // annotation enabling injecting dependencies
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/carTrip")
    public Trip fetchCarTrip(@RequestParam String origin, @RequestParam String destination) {
        City originCity = buildCityFromString(origin);
        City destinationCity = buildCityFromString(destination);
        return carService.getCarTrip(originCity,destinationCity);
    }

    @GetMapping("/allCarTrips")
    public ArrayList<Trip> fetchAllTrips(@RequestParam String origin) {
        City originCity = buildCityFromString(origin);
        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");
        return carService.getAllCarTrips(originCity,destinations);
    }

    private City buildCityFromString(String string) {
        String[] values = string.split(",");
        String cityName = values[0];
        float cityX = Float.parseFloat(values[1]);
        float cityY = Float.parseFloat(values[2]);
        return new City(cityName, cityX, cityY);
    }

}
