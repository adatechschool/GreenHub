package com.greenhub.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.*;
import com.greenhub.models.apis.plane.PlaneTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PlaneService {


    private final WebClient planeApi;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    @Autowired
    public PlaneService(@Value("${planeApi.url}") String apiUrl,
                        WebClient.Builder webClientBuilder,
                        ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.baseUrl = apiUrl;
        this.planeApi = webClientBuilder
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("x-api-key", "sh428739766321522266746152871799")
                .build();
    }


    public Trip getPlaneTrip(City origin, City destination) {
        if (origin.getName().equals(destination.getName())) {
            // If they are the same, return a Trip object with values set to 0
            return new Trip(origin, destination, 0, new Plane(), 0, 0, 0);
        }
        try {
            // Définir les variables
            String originIata = origin.getIataCode();
            String destinationIata = destination.getIataCode();

            // Construire le corps de la requête avec les variables
            String requestBody = String.format("{ \"query\": { \"market\": \"FR\", \"locale\": \"fr-FR\", \"currency\": \"EUR\", \"queryLegs\": [{ \"originPlaceId\": { \"iata\": \"%s\" }, \"destinationPlaceId\": { \"iata\": \"%s\" }, \"date\": { \"year\": 2024, \"month\": 2, \"day\": 23 } }], \"adults\": 1, \"childrenAges\": [], \"cabinClass\": \"CABIN_CLASS_ECONOMY\", \"excludedAgentsIds\": [], \"excludedCarriersIds\": [], \"includedAgentsIds\": [], \"includedCarriersIds\": [], \"includeSustainabilityData\": true, \"nearbyAirports\": false } }", originIata, destinationIata);

            // Effectuer la requête POST avec WebClient
            String planeApiJSON = planeApi.post()
                    .uri("search/create")
                    .body(BodyInserters.fromValue(requestBody))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // Bloquer jusqu'à ce que la réponse soit récupérée (à utiliser judicieusement dans un environnement réactif)


            PlaneTrips flightResponse = objectMapper.readValue(planeApiJSON, PlaneTrips.class);
            ModeOfTransport plane = new Plane();
            int distance = (int) DistanceCalculator.calculateDistance(origin,destination);

            return new Trip(
                    origin,
                    destination,
                    distance,
                    plane,
                    flightResponse.content.stats.itineraries.getMinDuration(),
                    0,
                    distance * plane.getCO2PerKilometer()

            );
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Trip> getAllPlaneTrips(City origin,  City[] destinations) {
        ArrayList<Trip> planeTrips = new ArrayList<>();
        for (City destination : destinations) {
            try {
                Trip trip = getPlaneTrip(origin, destination);
                planeTrips.add(trip);
            } catch (HttpClientErrorException e) {
                System.err.println("Erreur lors de l'appel à " + destination.getName() + ": " + e.getRawStatusCode() + " - " + e.getStatusText());
            } catch (Exception e) {
                System.err.println("Erreur générale lors de l'appel à " + destination.getName() + ": " + e.getMessage());
            }
        }
        planeTrips.removeIf(Objects::isNull);
        return planeTrips;
    }

}
