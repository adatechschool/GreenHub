package com.greenhub.models.test;

import com.greenhub.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripTest {

    @Test
    public void getCO2Test() {
        //Testing default values of co2 emissions by mode of transport
        City nantes = new City("Nantes", 0, 0);
        City lyon = new City("Lyon", 0, 0);
        Trip myPlaneTrip =  new Trip(nantes, lyon, 538, new Plane(), 0, 0);
        assertEquals(myPlaneTrip.getCo2(), 153);
        Trip myTrainTrip = new Trip(nantes, lyon, 538, new Train(), 0, 0);
        assertEquals(myTrainTrip.getCo2(), 2);
        Trip myCarTrip = new Trip(nantes, lyon, 645, new Car(), 0, 0);
        assertEquals(myCarTrip.getCo2(), 139);
    }


}
