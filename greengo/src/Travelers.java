import java.util.ArrayList;
import java.util.HashMap;


public class Travelers {
    private City livingCity;
    private int numberOfTravelers;


    // Constructeur
    public Travelers(City livingCity,int numberOfTravelers) {
        this.livingCity = livingCity;
        this.numberOfTravelers = numberOfTravelers;
    }

    public City getLivingCity() {
        return livingCity;
    }
    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }

    public HashMap<City, Integer> getCO2PerDestination () {
        /*database of possible destinations*/
        //Create a dictionnary to store the key value / pair : city / co2
        HashMap<City, Integer> co2PerCity = new HashMap<>();
        /*loop into destinations array*/
        /*get the CO2 emissions for each trip, for now we manually create the trips*/
        Trip trip1 = new Trip(this.livingCity,Main.nantes,0);
        Trip trip2 = new Trip(this.livingCity,Main.lyon,538);
        Trip trip3 = new Trip(this.livingCity,Main.paris,372);
        /*populate the hash table*/
        co2PerCity.put(Main.nantes, trip1.getCO2());
        co2PerCity.put(Main.lyon, trip2.getCO2());
        co2PerCity.put(Main.paris, trip3.getCO2());

        return co2PerCity;
        }
}
