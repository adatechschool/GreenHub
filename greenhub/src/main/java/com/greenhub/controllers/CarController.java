package com.greenhub.controllers;
import com.greenhub.models.Trip;
import com.greenhub.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // to use a REST api
@RequestMapping("/cars") // mapping corresponding to the CarController class
public class CarController {

    private final CarService carService;

    @Autowired // annotation enabling injecting dependencies
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/carTrip")
    public String fetchDataFromApi (@RequestParam String departureGPSCoordinates, @RequestParam String arrivalGPSCoordinates) {
        return carService.getCarTrip(departureGPSCoordinates,arrivalGPSCoordinates);
    }
    /* public Trip fetchDataFromApi (@RequestParam String departureGPSCoordinates, @RequestParam String arrivalGPSCoordinates) {
        return carService.getCarTrip(departureGPSCoordinates,arrivalGPSCoordinates);
    }

     */
}
