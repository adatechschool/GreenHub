package com.greenhub.controllers;
import com.greenhub.models.Trip;
import com.greenhub.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/trainTrip")
    public Trip fetchDataFromApi(@RequestParam String origin, @RequestParam String destination) {
        return trainService.getTrainTrip(origin,destination);
    }
}

