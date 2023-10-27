import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/*
public class Tests {

    @Test
    public void getCO2Test() {
        City Nantes = new City("Nantes", 0, 0);
        City Lyon = new City("Lyon", 0, 0);

        ModeOfTransport plane = new Plane();
        Trip myTrip1 = new Trip(Nantes,Lyon,538, plane);
        Assert.assertEquals(myTrip1.getCO2(), 153);

        ModeOfTransport train = new Train();
        Trip myTrip2 = new Trip(Nantes,Lyon,538, train);
        Assert.assertEquals(myTrip2.getCO2(), 2);

        ModeOfTransport car = new Car();
        Trip myTrip3 = new Trip(Nantes,Lyon,538, car);
        Assert.assertEquals(myTrip3.getCO2(), 116);
    }


    @Test
     public void getCO2PerDestinationTest() {
        //create the travelers instance for test
        Travelers travelersTest = new Travelers(Main.nantes, 1);
        Assert.assertTrue(153 == travelersTest.getCO2PerDestination().get(Main.lyon));
        Travelers travelersTest2 = new Travelers(Main.nantes, 2);
        Assert.assertTrue(306 == travelersTest2.getCO2PerDestination().get(Main.lyon));
    }
    @Test
    // fonction: pour chaque destination faire la somme des emissions de CO2 de tous les voyageurs & retourner la destination la + économe en C02
    public void getLowestCO2DestinationTest() {
        Travelers groupOfTravelers[] = {Main.traveler1,Main.traveler2,Main.traveler3,Main.traveler4,Main.traveler5};
        Map.Entry<City,Integer> result = new AbstractMap.SimpleEntry<City, Integer>(Main.bordeaux,417);
        Assert.assertEquals(result, Main.getLowestCO2Destination(groupOfTravelers));
    }
}*/