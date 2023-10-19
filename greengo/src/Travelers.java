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

    public ArrayList<Trip> getPossibleTrips () {
        //Create an arraylist to store the possible destinations
        ArrayList<Trip> possibleTrips = new ArrayList<>();
        //get possible destinations
        for (Trip trip: Main.allTrips) {
            if (this.livingCity == trip.getDepartureCity()) {
                    possibleTrips.add(trip);
            }
        }
        //return the arraylist
        return possibleTrips;
        }
}

