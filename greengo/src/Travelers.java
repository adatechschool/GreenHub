import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


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
        //Create a dictionary to store the key value / pair : city / co2
        HashMap<City, Integer> co2PerCity = new HashMap<>();
        /*get possible destinations*/
        for (Trip trip: Main.allTrips) {
            if (this.livingCity == trip.getDepartureCity()) {
                if (Objects.equals(trip.getModeOfTransport().getTransportName(), "Car")) {
                    co2PerCity.put(trip.getArrivalCity(), trip.getCO2());
                }
                else co2PerCity.put(trip.getArrivalCity(), trip.getCO2() * this.numberOfTravelers);
            }
        }
        // {{Paris, Plane, 300},{Nantes, Car, 100}}
        return co2PerCity;
        }
}
