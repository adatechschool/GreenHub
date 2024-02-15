package com.greenhub.services.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenhub.models.City;
import com.greenhub.models.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import com.greenhub.services.TrainService;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class TrainServiceTest {

    @MockBean
    private TrainService trainService;

    @MockBean
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        when(webClientBuilder.defaultHeader(any(String.class), any(String.class))).thenReturn(webClientBuilder);
        when(webClientBuilder.baseUrl(any(String.class))).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
    }

    @Test
    public void testGetTrainTrip_sameOriginAndDestination() throws JsonProcessingException {
        City city = new City("Paris", 1, 1);
        Trip trip = trainService.getTrainTrip(city, city);
        assertEquals(null, trip);
    }

    @Test
    public void testGetTrainTrip_nullApiResponse() throws JsonProcessingException {
        City origin = new City("Paris", 1, 1);
        City destination = new City("Nantes", 2, 2);

        // Simuler la réponse nulle de l'API externe
        lenient().when(webClient.get()).thenReturn(requestHeadersUriSpec);
        lenient().when(requestHeadersUriSpec.uri(any(String.class), any(Object.class), any(Object.class))).thenReturn(requestHeadersSpec);
        lenient().when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        lenient().when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.empty());

        // Appeler la méthode à tester
        Trip trip = trainService.getTrainTrip(origin, destination);

        // Vérifier que null est retourné
        assertEquals(null, trip);
    }

    @Test
    public void testGetTrainTrip_unparseableApiResponse() throws JsonProcessingException {
        City origin = new City("Paris", 1, 1);
        City destination = new City("Nantes", 2, 2);

        // Simulate an invalid but non-null response from the external API
        lenient().when(webClient.get()).thenReturn(requestHeadersUriSpec);
        lenient().when(requestHeadersUriSpec.uri(any(String.class), any(Object.class), any(Object.class))).thenReturn(requestHeadersSpec);
        lenient().when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        lenient().when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just("{brokenJson : {"));

        // Appeler la méthode à tester
        Trip trip = trainService.getTrainTrip(origin, destination);

        // Vérifier que null est retourné
        assertEquals(null, trip);
    }


}
