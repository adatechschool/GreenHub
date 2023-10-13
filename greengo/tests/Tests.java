import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.*;

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
        //Create a dictionnary to store the key value / pair : city / co2
        HashMap<City, Integer> co2PerCity = new HashMap<>();
        co2PerCity.put(Main.nantes, 0);
        co2PerCity.put(Main.lyon, 153);
        co2PerCity.put(Main.paris, 106);
        Assert.assertEquals(co2PerCity,travelersTest.getCO2PerDestination());
    }
    /*@Test
    // fonction: pour chaque destination faire la somme des emissions de CO2 de tous les voyageurs & retourner la destination la + économe en C02
    public void getLowestCO2DestinationTest() {
        HashMap<City,Integer> result = new HashMap<>();
        result.put(Main.paris, 300);
        Assert.asserEquals(result, Main.getLowestCO2Destination(Main.groupOfTravelers));

    }*/
}