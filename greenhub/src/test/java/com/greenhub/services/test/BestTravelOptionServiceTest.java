package com.greenhub.services.test;

import com.greenhub.models.*;
import com.greenhub.repository.DataRepository;
import com.greenhub.services.BestTravelOptionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTravelOptionServiceTest {
    @Test
    public void testGetLowestCo2Option() {
        GlobalTravelOption result = BestTravelOptionService.getLowestCo2Option(DataRepository.groupOfTravelers, DataRepository.allDestinations);
        // Ajoutez des assertions pour vérifier le résultat
        assertEquals(result.getDestination(), "Paris");
    }
}