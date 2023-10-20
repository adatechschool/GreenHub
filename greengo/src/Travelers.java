import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Travelers {

    private String travelersName;
    private City livingCity;
    private int numberOfTravelers;


    // Constructeur
    public Travelers(String travelersName, City livingCity,int numberOfTravelers) {
        this.travelersName = travelersName;
        this.livingCity = livingCity;
        this.numberOfTravelers = numberOfTravelers;
    }

    public String getName() {
        return travelersName;
    }
    public City getLivingCity() {
        return livingCity;
    }
    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }

    public ArrayList<Trip> getPossibleOptionsPerDestination (City destination) {
        //Create an arraylist to store the possible options for the destination
        ArrayList<Trip> possibleOptions = new ArrayList<>();
        //loop into all the trips and add the relevant elements to the arraylist
        for (Trip trip: Main.allTrips) {
            if (this.livingCity == trip.getDepartureCity() && trip.getArrivalCity() == destination) {
                possibleOptions.add(trip);
            }
        }
        //return the arraylist
        return possibleOptions;
    }

    public Trip getBestOptionPerDestination (City destination) {
        //Create an arraylist to store the possible options for the destination
        ArrayList<Trip> possibleOptions = this.getPossibleOptionsPerDestination(destination);
        //loop into the possible options and keep the one with the lowest CO2 emission
        int minCO2 = possibleOptions.get(0).getCO2()*this.numberOfTravelers;
        Trip bestOption = possibleOptions.get(0);
        for (int i=1; i<possibleOptions.size(); i++) {
            if(possibleOptions.get(i).getCO2() < minCO2) {
                minCO2 = possibleOptions.get(i).getCO2()*this.numberOfTravelers;
                bestOption = possibleOptions.get(i);
            }
        }
        //return the best option
        return bestOption;
    }
}

