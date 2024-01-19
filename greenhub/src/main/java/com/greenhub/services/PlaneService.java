package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.*;
import com.greenhub.models.plane.Arrival;
import com.greenhub.models.plane.Departure;
import com.greenhub.models.plane.FlightData;
import com.greenhub.models.plane.FlightResponse;
import com.greenhub.repository.CityLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class PlaneService {


    private final WebClient planeApi;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    @Autowired
    public PlaneService(@Value("${planeApi.url}") String apiUrl,
                        @Value("${planeApi.accessKey}") String accessKey,
                        WebClient.Builder webClientBuilder,
                        ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.baseUrl = apiUrl + "?access_key=" + accessKey;
        this.planeApi = webClientBuilder
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }


    public Trip getPlaneTrip(City origin, City destination) {
        if (origin.getName().equals(destination.getName())) {
            // If they are the same, return a Trip object with values set to 0
            return new Trip(origin, destination, 0, new Plane(), 0, 0, 0);
        }
        try {
            String url = baseUrl +
                    "&dep_iata=" + origin.getIataCode() +
                    "&arr_iata=" + destination.getIataCode() +
                    "&flight_status=scheduled" +
                    "&limit=1";

            String planeApiJSON = planeApi.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            FlightResponse flightResponse = objectMapper.readValue(planeApiJSON, FlightResponse.class);

            // Suppose there is only one flight in the response
            FlightData flightData = flightResponse.getData()[0];
            Departure departure = flightData.getDeparture();
            Arrival arrival = flightData.getArrival();

            ZonedDateTime departureTime = ZonedDateTime.parse(departure.getScheduled());
            ZonedDateTime arrivalTime = ZonedDateTime.parse(arrival.getScheduled());

            ModeOfTransport plane = new Plane();
            Duration transportTime = Duration.between(departureTime, arrivalTime);
            int distance = (int) DistanceCalculator.calculateDistance(origin,destination);

            return new Trip(
                    origin,
                    destination,
                    distance,
                    plane,
                    (int) transportTime.toMinutes(),
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
