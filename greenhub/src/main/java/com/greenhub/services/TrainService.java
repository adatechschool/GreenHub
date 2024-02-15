package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.Train;
import com.greenhub.models.Trip;
import com.greenhub.models.apis.train.TrainTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class TrainService {

    private final WebClient trainApi;
    private final ObjectMapper objectMapper;

    @Autowired
    public TrainService(@Value("${trainApi.url}") String apiUrl,
                        @Value("${trainApi.username}") String username,
                        @Value("${trainApi.password}") String password,
                        WebClient.Builder webClientBuilder,
                        ObjectMapper objectMapper) {
        this.trainApi = webClientBuilder
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", createBasicAuthHeader(username, password))
                .build();
        this.objectMapper = objectMapper;
    }


    public Trip getTrainTrip(City origin, City destination) throws JsonProcessingException {
        // Check if the origin and destination cities are the same
        if (Objects.equals(origin.getName(), destination.getName())) {
            // If they are the same, return a Trip object with values set to 0
            return new Trip(origin, destination, 0, new Train(), 0, 0, 0);
        }

        try {
            // Rest of your existing code to make the API call and process the response
            String trainApiJSON = trainApi.get()
                    .uri("/journeys?from={origin}&to={destination}",
                            origin.coordinatesAsString(), destination.coordinatesAsString())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Check if the API response is null
            if (trainApiJSON == null) {
                // Handle the case where the API response is null (throw an exception, log an error, etc.)
                throw new IllegalStateException("API response is null.");
            }

            // Rest of your existing code to parse the API response and create a Trip object
            TrainTrips apiResponse = objectMapper.readValue(trainApiJSON, TrainTrips.class);

            // Check if parsed response is null
            if (apiResponse == null) {
                // Handle the case where apiResponse is null (throw an exception, log an error, etc.)
                throw new IllegalStateException("API response could not be parsed.");
            }

            return new Trip(
                    origin,
                    destination,
                    Math.round((float) apiResponse.getJourneys().get(0).totalDistance() / 1000),
                    new Train(),
                    apiResponse.getJourneys().get(0).getDuration() / 60,
                    0,
                    (int) apiResponse.getJourneys().get(0).getCo2_emission().getValue()
            );
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Trip> getAllTrainTrips(City origin, City[] destinations) {
        ArrayList<Trip> trainTrips = new ArrayList<>();
        for (City destination : destinations) {
            try {
                Trip trip = getTrainTrip(origin, destination);
                trainTrips.add(trip);
            } catch (HttpClientErrorException e) {
                // Capturez les exceptions spécifiques liées à une erreur HTTP (par exemple, 404 Not Found)
                System.err.println("Erreur lors de l'appel à " + destination.getName() + ": " + e.getRawStatusCode() + " - " + e.getStatusText());
            } catch (Exception e) {
                // Capturez les autres exceptions
                System.err.println("Erreur générale lors de l'appel à " + destination.getName() + ": " + e.getMessage());
            }
        }
        trainTrips.removeIf(Objects::isNull);
        return trainTrips;
    }

    // Create the basic authentification header
    private String createBasicAuthHeader(String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = java.util.Base64.getEncoder().encode(auth.getBytes());
        return "Basic " + new String(encodedAuth);
    }
}


