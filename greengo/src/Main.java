import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);
    public static City bordeaux = new City("Bordeaux", 0, 0);
    public static City toulouse = new City("Toulouse", 0, 0);

    public static City allCities[] = {nantes,lyon,paris,bordeaux,toulouse};

    /*-----------------*/

    public static ModeOfTransport modeOfTransport = new Plane();

    /*-----------------*/

    public static Trip trip1 = new Trip(nantes,nantes,0, modeOfTransport);
    public static Trip trip2 = new Trip(nantes,lyon,538, modeOfTransport);
    public static Trip trip3 = new Trip(nantes,paris,372, modeOfTransport);
    public static Trip trip4 = new Trip(nantes,bordeaux,267, modeOfTransport);
    public static Trip trip5 = new Trip(nantes,toulouse,455, modeOfTransport);

    /*-----------------*/

    public static Trip trip6 = new Trip(lyon,nantes,538, modeOfTransport);
    public static Trip trip7 = new Trip(lyon,lyon,0, modeOfTransport);
    public static Trip trip8 = new Trip(lyon,paris,412, modeOfTransport);
    public static Trip trip9 = new Trip(lyon,bordeaux,465, modeOfTransport);
    public static Trip trip10 = new Trip(lyon,toulouse,375, modeOfTransport);


    /*-----------------*/
    public static Trip trip11 = new Trip(paris,nantes,372, modeOfTransport);
    public static Trip trip12 = new Trip(paris,lyon,412, modeOfTransport);
    public static Trip trip13 = new Trip(paris,paris,0, modeOfTransport);
    public static Trip trip14 = new Trip(paris,bordeaux,526, modeOfTransport);
    public static Trip trip15 = new Trip(paris,toulouse,604, modeOfTransport);

    /*-----------------*/

    public static Trip trip16 = new Trip(bordeaux,nantes,267, modeOfTransport);
    public static Trip trip17 = new Trip(bordeaux,lyon,465, modeOfTransport);
    public static Trip trip18 = new Trip(bordeaux,paris,526, modeOfTransport);
    public static Trip trip19 = new Trip(bordeaux,toulouse,213, modeOfTransport);
    public static Trip trip20 = new Trip(bordeaux,bordeaux,0, modeOfTransport);

    /*-----------------*/

    public static Trip trip21 = new Trip(toulouse,paris,604, modeOfTransport);
    public static Trip trip22 = new Trip(toulouse,nantes,455, modeOfTransport);
    public static Trip trip23 = new Trip(toulouse,lyon,375, modeOfTransport);
    public static Trip trip24 = new Trip(toulouse,toulouse,0, modeOfTransport);
    public static Trip trip25 = new Trip(toulouse,bordeaux,213, modeOfTransport);


    public static Trip allTrips[] = {trip1,trip2,trip3,trip4,trip5,trip6,trip7,trip8,trip9,trip10,trip11,trip12,trip13,trip14,trip15,trip16,trip17,trip18,trip19,trip20,trip21,trip22,trip23,trip24,trip25};

    public static Travelers traveler1 = new Travelers(nantes,1);
    public static Travelers traveler2 = new Travelers(lyon,1);
    public static Travelers traveler3 = new Travelers(paris,1);
    public static Travelers traveler4 = new Travelers(bordeaux,1);
    public static Travelers traveler5 = new Travelers(toulouse,1);

    /*public static Travelers groupOfTravelers[] = {traveler1,traveler2,traveler3,traveler4,traveler5};*/



    public static void main(String[] args) {

    }


    public static Entry<City,Integer> getLowestCO2Destination(Travelers [] groupOfTravelers) {
        HashMap<City,Integer> SumC02PerDestination = new HashMap<>();
        for (City city : allCities){
            SumC02PerDestination.put(city, 0);
        }

        HashMap<City,Integer> CO2PerCity = new HashMap<>();
        for (Travelers traveler : groupOfTravelers){
            // for each traveller get the C02 emission for each destination
            CO2PerCity.putAll(traveler.getCO2PerDestination());
            // for each destination calculate the global C02 emissions
            CO2PerCity.forEach((city, CO2) -> SumC02PerDestination.put(city, SumC02PerDestination.get(city) + CO2));
        }

        // return the lowest CO2 emission destination & the value
        Entry<City,Integer>  entryWithMinValue = Collections.min(SumC02PerDestination.entrySet(), Map.Entry.comparingByValue());
        System.out.println("Clé : " + entryWithMinValue.getKey().getName() + ", Valeur : " + entryWithMinValue.getValue());
        return entryWithMinValue;
    }
}