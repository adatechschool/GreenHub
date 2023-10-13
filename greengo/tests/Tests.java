import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Tests {
    @Test
    public void getCO2Test() {
        City Nantes = new City("Nantes", 0, 0);
        City Lyon = new City("Lyon", 0, 0);
        Trip myTrip = new Trip(Nantes,Lyon,538);
        Assert.assertEquals(myTrip.getCO2(), 153);
    }
    @Test
    public void getCO2PerDestinationTest() {
        /*create the travelers instance for test*/
        Travelers travelersTest = new Travelers(Main.nantes, 1);
        Assert.assertTrue(153 == travelersTest.getCO2PerDestination().get(Main.lyon));
    }
    @Test
    // fonction: pour chaque destination faire la somme des emissions de CO2 de tous les voyageurs & retourner la destination la + économe en C02
    public void getLowestCO2DestinationTest() {
        Travelers groupOfTravelers[] = {Main.traveler1,Main.traveler2,Main.traveler3,Main.traveler4,Main.traveler5};
        Map.Entry<City,Integer> result = new AbstractMap.SimpleEntry<City, Integer>(Main.bordeaux,417);
        Assert.assertEquals(result, Main.getLowestCO2Destination(groupOfTravelers));
    }
}