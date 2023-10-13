import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);

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
        for (int i = 0;i < 3; i++) {
            HashMap<City,Integer> CO2PerCity = new HashMap<>();
            CO2PerCity = groupOfTravelers[i].getCO2PerDestination();
            CO2PerCity.forEach((key, value) -> System.out.println(key.getName() + " = " + value));
            System.out.println(CO2PerCity.get(lyon));
            // forEach pour hashmap
            CO2PerCity.forEach((city, CO2) -> SumC02PerDestination.put(city, SumC02PerDestination.get(city) + CO2));
        }
        System.out.println(SumC02PerDestination.get(lyon));
        // for each destination calculate the global C02 emissions

        // return the lowest CO2 emission destination & the value
        HashMap<City,Integer> result = new HashMap<>();
        result.put(Main.paris, 300);
        return result;
    }
}