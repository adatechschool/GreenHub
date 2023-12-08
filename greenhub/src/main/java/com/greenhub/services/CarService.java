package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.ModeOfTransport;
import com.greenhub.models.Car;
import com.greenhub.models.Trip;
import com.greenhub.models.car.CarTrips;
import com.greenhub.models.train.TrainTrips;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CarService {

    @Value("https://api.openrouteservice.org/v2/directions/driving-car")
    private String apiUrl;

    @Value("5b3ce3597851110001cf6248f13cadea48444e5b85686de98a983a78")
    private String apiKey;

    public Trip getCarTrip(String departureGPSCoordinates, String arrivalGPSCoordinates) {
        //create the headers of the api call
        WebClient carApi = WebClient.builder()
                .baseUrl(apiUrl + "?api_key=" + apiKey + "&start=" + departureGPSCoordinates + "&end=" + arrivalGPSCoordinates)
                .defaultHeader("Content-Type", "application/json")
                .build();

        //consume the api
        String carApiJSON = carApi.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //create an object mapper to parse the api response to make it a trip
        ObjectMapper om = new ObjectMapper();

        try {
            //read the carApiJSON response and serialize it into a CarTrips object
            CarTrips apiResponse = om.readValue(carApiJSON, CarTrips.class);

            float departureX = Float.parseFloat(metadata.query.coordinates[0][0]);
            float departureY = Float.parseFloat(metadata.query.coordinates[0][1]);

            ModeOfTransport car = new Car();
            City departureCity = new City("Paris", departureX, departureY);
            City arrivalCity = new City("Marseille", arrivalX, arrivalY);

            // build the trip instance of Trip class based on elements provided by API
            return new Trip(
                    departureCity,
                    arrivalCity,
                    0,
                    car,
                    0,
                    0
            );

        } catch (JsonProcessingException e) {
            System.out.println("issue with serialization of json");
            throw new RuntimeException(e);
        }
    }
}

