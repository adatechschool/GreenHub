package com.greenhub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.ModeOfTransport;
import com.greenhub.models.Car;
import com.greenhub.models.Trip;
import com.greenhub.models.car.CarTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CarService {

    private final WebClient carApi;
    private final ObjectMapper objectMapper;

    @Autowired
    public CarService(@Value("${carApi.apiUrl}") String apiUrl,
                      @Value("${carApi.apiKey}") String apiKey,
                        WebClient.Builder webClientBuilder,
                        ObjectMapper objectMapper) {
        this.carApi = webClientBuilder
                .baseUrl(apiUrl + "?api_key=" + apiKey)
                .defaultHeader("Content-Type", "application/json") // force que le contenu de la requête soit en JSON
                .build();
        this.objectMapper = objectMapper;
    }

    public Trip getCarTrip(City origin, City destination) {

        try {
            //consume the api
            String carApiJSON = carApi.get()
                    .uri("&start=" + origin.getY() + ',' + origin.getX() + "&end=" + destination.getY() + ',' + destination.getX())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // read the carApiJSON response and serialize it into a CarTrips object
            CarTrips apiResponse = objectMapper.readValue(carApiJSON,CarTrips.class);

            int distance = apiResponse.features.get(0).properties.segments.get(0).getDistance();
            Car car = new Car();

            return new Trip(
                    origin,
                    destination,
                    distance,
                    car,
                    apiResponse.features.get(0).properties.segments.get(0).getDuration(),
                    0,
                    distance*car.getCO2PerKilometer(),
                    );

        } catch (JsonProcessingException e) {
            System.out.println("issue with serialization of json");
            throw new RuntimeException(e);
        }
    }
}

