package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.ModeOfTransport;
import com.greenhub.models.Train;
import com.greenhub.models.Trip;
import com.greenhub.models.train.TrainTrips;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TrainService {

    @Value("${trainApi.url}")
    private String apiUrl;
    @Value("${trainApi.username}")
    private String username;
    @Value("${trainApi.password}")
    private String password;


    public Trip getTrainTrip(String origin, String destination) {
        WebClient trainApi = WebClient.builder()
                .baseUrl(apiUrl + "/journeys?from=" + origin + "&to=" + destination)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", createBasicAuthHeader(username, password))
                .build();

        String trainApiJSON = trainApi.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper om = new ObjectMapper();
        try {
            TrainTrips apiResponse = om.readValue(trainApiJSON, TrainTrips.class);
            String[] originCoordinates = origin.split(";");
            float originX = Float.parseFloat(originCoordinates[1]);
            float originY = Float.parseFloat(originCoordinates[0]);

            String[] destinationCoordinates = destination.split(";");
            float destinationX = Float.parseFloat(destinationCoordinates[1]);
            float destinationY = Float.parseFloat(destinationCoordinates[0]);

            ModeOfTransport train = new Train();

            return new Trip(new City("Paris", originX, originY),
                    new City("Marseille", destinationX, destinationY),
                    (int) Math.round(apiResponse.getJourneys().get(0).getCo2_emission().getValue()/train.getCO2PerKilometer()),
                    train,
                    apiResponse.getJourneys().get(0).getDuration(),
                    0);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //Create the basic authentification header
    private String createBasicAuthHeader(String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = java.util.Base64.getEncoder().encode(auth.getBytes());
        return "Basic " + new String(encodedAuth);
    }


}
