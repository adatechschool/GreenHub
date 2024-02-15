package com.greenhub.services.test;

import com.greenhub.models.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.greenhub.services.BestTravelOptionService;
import java.util.ArrayList;
import java.util.Arrays;

public class BestTravelOptionServiceTest {
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);
    public static Travelers lyonnais = new Travelers("Lyonnais", lyon, 5, 300, 1000);
    public static Travelers parisiens = new Travelers("Parisiens", paris, 2, 300, 1000);

    public static BestTravelOptionService service = new BestTravelOptionService();

    @Test
    public void testGetLowestCo2Option_emptyTravelers() {
        ArrayList<Travelers> groupOfTravelers = new ArrayList<>();
        City[] destinations = { paris, lyon};
        ArrayList<Trip> allTrips = new ArrayList<>(Arrays.asList(new Trip(paris, lyon, 10, new Car(), 100, 100)));

        ArrayList<GlobalTravelOption> result = service.getLowestCo2Option(groupOfTravelers, destinations, allTrips);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetLowestCo2Option_emptyDestinations() {
        ArrayList<Travelers> groupOfTravelers = new ArrayList<>(Arrays.asList(parisiens, lyonnais));
        City[] destinations = {};
        ArrayList<Trip> allTrips = new ArrayList<>(Arrays.asList(new Trip(paris, lyon, 10, new Car(), 100, 100)));

        ArrayList<GlobalTravelOption> result = service.getLowestCo2Option(groupOfTravelers, destinations, allTrips);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetLowestCo2Option_emptyTrips() {
        ArrayList<Travelers> groupOfTravelers = new ArrayList<>(Arrays.asList(parisiens, lyonnais));
        City[] destinations = { paris, lyon};
        ArrayList<Trip> allTrips = new ArrayList<>();

        ArrayList<GlobalTravelOption> result = service.getLowestCo2Option(groupOfTravelers, destinations, allTrips);

        assertTrue(result.isEmpty());
    }

}