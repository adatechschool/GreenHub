import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);

    public static Trip trip1 = new Trip(nantes,nantes,0);
    public static Trip trip2 = new Trip(nantes,lyon,538);
    public static Trip trip3 = new Trip(nantes,paris,372);
    public static Trip trip4 = new Trip(lyon,nantes,538);
    public static Trip trip5 = new Trip(lyon,lyon,0);
    public static Trip trip6 = new Trip(lyon,paris,412);
    public static Trip trip7 = new Trip(paris,nantes,372);
    public static Trip trip8 = new Trip(paris,lyon,412);
    public static Trip trip9 = new Trip(paris,paris,0);

    public static Trip allTrips[] = {trip1,trip2,trip3,trip4,trip5,trip6,trip7,trip8,trip9};

    public static Travelers traveler1 = new Travelers(nantes,1);
    public static Travelers traveler2 = new Travelers(lyon,1);
    public static Travelers traveler3 = new Travelers(paris,1);

    public static Travelers groupOfTravelers[] = {traveler1,traveler2,traveler3};



    public static void main(String[] args) {
        getLowestCO2Destination(groupOfTravelers);
    }


    public static HashMap<City,Integer> getLowestCO2Destination(Travelers [] groupOfTravelers) {
        HashMap<City,Integer> SumC02PerDestination = new HashMap<>();
        SumC02PerDestination.put(nantes, 0);
        SumC02PerDestination.put(lyon, 0);
        SumC02PerDestination.put(paris, 0);

        // for each traveller get the C02 emission for each destination
        HashMap<City,Integer> CO2PerCity = new HashMap<>();
        for (int i = 0;i < 3; i++) {
            CO2PerCity.putAll(groupOfTravelers[i].getCO2PerDestination());
            CO2PerCity.forEach((key, value) -> System.out.println(key.getName() + " = " + value));
            System.out.println(CO2PerCity.get(lyon));

            // for each destination calculate the global C02 emissions
            CO2PerCity.forEach((city, CO2) -> SumC02PerDestination.put(city, SumC02PerDestination.get(city) + CO2));
        }
        System.out.println("lyon :" + SumC02PerDestination.get(lyon));
        System.out.println("Paris :" + SumC02PerDestination.get(paris));
        System.out.println("Nantes :" + SumC02PerDestination.get(nantes));


        // return the lowest CO2 emission destination & the value
        
        HashMap<City,Integer> result = new HashMap<>();


        return result;
    }
}