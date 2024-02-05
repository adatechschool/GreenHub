package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.Car;
import com.greenhub.models.Train;
import com.greenhub.models.Trip;
import com.greenhub.models.apis.car.CarTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CarService {

    private final WebClient carApi;
    private final ObjectMapper objectMapper;

    @Value("${carApi.apiKey}") String apiKey;

    @Autowired
    public CarService(@Value("${carApi.apiUrl}") String apiUrl,
                        WebClient.Builder webClientBuilder,
                        ObjectMapper objectMapper) {
        this.carApi = webClientBuilder
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/json") // force que le contenu de la requête soit en JSON
                .build();
        this.objectMapper = objectMapper;
    }

    public Trip getCarTrip(City origin, City destination) {
        // Check if the origin and destination cities are the same
        if (origin.getName().equals(destination.getName())) {
            // If they are the same, return a Trip object with values set to 0
            return new Trip(origin, destination, 0, new Car(), 0, 0, 0);
        }
        try {
            //consume the api
            String carApiJSON = carApi.get()
                    .uri("?api_key=" + apiKey + "&start=" + origin.getY() + ',' + origin.getX() + "&end=" + destination.getY() + ',' + destination.getX())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Check if the API response is null
            if (carApiJSON == null) {
                // Handle the case where the API response is null (throw an exception, log an error, etc.)
                throw new IllegalStateException("API response is null.");
            }

            // read the carApiJSON response and serialize it into a CarTrips object
            CarTrips apiResponse = objectMapper.readValue(carApiJSON,CarTrips.class);

            // Check if apiResponse is null
            if (apiResponse == null) {
                // Handle the case where apiResponse is null (throw an exception, log an error, etc.)
                throw new IllegalStateException("API response could not be parsed.");
            }

            int distance = apiResponse.features.get(0).properties.segments.get(0).getDistance()/1000;
            Car car = new Car();

            return new Trip(
                    origin,
                    destination,
                    distance,
                    car,
                    apiResponse.features.get(0).properties.segments.get(0).getDuration()/60,
                    0,
                    distance*car.getCO2PerKilometer()
                    );

        } catch (JsonProcessingException e) {
            System.out.println("issue with serialization of json");
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Trip> getAllCarTrips(City origin, City[] destinations) {
        ArrayList<Trip> carTrips = new ArrayList<>();
        for (City destination : destinations) {
            try {
                Trip trip = getCarTrip(origin, destination);
                carTrips.add(trip);
            } catch (HttpClientErrorException e) {
                System.err.println("Erreur lors de l'appel à " + destination.getName() + ": " + e.getRawStatusCode() + " - " + e.getStatusText());
            } catch (Exception e) {
                System.err.println("Erreur générale lors de l'appel à " + destination.getName() + ": " + e.getMessage());
            }
        }
        carTrips.removeIf(Objects::isNull);
        return carTrips;
    }
}

