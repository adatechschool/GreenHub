import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*declare the CO2 emission per kilometer for a flight*/
        int CO2byKm = 285;
        /*create an array to store the trips*/
        ArrayList<Trip> trips = new ArrayList<Trip>();
        trips.add(new Trip("Nantes","Lyon",538));
        trips.add(new Trip("Nantes","Paris",372));
        trips.add(new Trip("Lyon","Paris",412));
        for (Trip trip: trips) {
            System.out.println(trip.getCO2());
        };
        /*get the C02 emissions for each trip*/

    }



}