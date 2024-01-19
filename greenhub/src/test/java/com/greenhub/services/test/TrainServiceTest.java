package com.greenhub.services.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.Trip;
import com.greenhub.models.apis.train.TrainTrips;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.greenhub.services.TrainService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrainServiceTest {

    @Mock
    private WebClient trainApiMock;

    @Mock
    private ObjectMapper objectMapperMock;

    @InjectMocks
    private TrainService trainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTrainTrip() throws JsonProcessingException {
        City origin = new City("Paris", 48.854368511010776F, 2.338717213104824F);
        City destination = new City("Marseille", 43.3046384916822F, 5.380587512275412F);

        // Mocking the response from the external API
        TrainTrips mockedApiResponse = new TrainTrips(/*...*/); // Create a mocked TrainTrips object
        String mockedApiResponseJson = " {\"journeys\":[\n" +
                "            {\n" +
                "            \"duration\": 13780,\n" +
                "            \"co2_emission\": {\n" +
                "            \"value\": 1562.27828\n" +
                "            },\n" +
                "            \"sections\": [\n" +
                "                {\n" +
                "                \"geojson\": {\n" +
                "                \"properties\": [\n" +
                "                    {\n" +
                "                    \"length\": 603\n" +
                "                    }\n" +
                "                ]\n" +
                "                }\n" +
                "            ]\n" +
                "            }]}";
        Mockito.when(trainApiMock.get()
                        .uri("/journeys?from={origin}&to={destination}",
                                origin.coordinatesAsString(), destination.coordinatesAsString())
                        .retrieve()
                        .bodyToMono(String.class))
                .thenReturn(Mono.just(mockedApiResponseJson));

        // Mocking ObjectMapper behavior
        Mockito.when(objectMapperMock.readValue(mockedApiResponseJson, TrainTrips.class))
                .thenReturn(mockedApiResponse);

        // Call the method to test
        Trip result = trainService.getTrainTrip(origin, destination);

        // Assert the result based on your expectations
        assertNotNull(result);
    }
}
