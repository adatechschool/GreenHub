import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TravelOption {
    private Travelers traveler;
    private Trip trip;

    public TravelOption(Travelers traveler, Trip trip ) {
        this.traveler = traveler;
        this.trip = trip;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public Travelers getTraveler() {
        return this.traveler;
    }

    public HashMap<Travelers, Trip> getTravelOption() {
        HashMap<Travelers, Trip> travelOption = new HashMap<>();
        travelOption.put(this.traveler,this.trip);
        return travelOption;
    }

    public int getCO2() {
        return trip.getCO2()*traveler.getNumberOfTravelers();
    }

    public void print() {
        System.out.println("Détails de l'option de voyage :");
            for (Map.Entry<Travelers, Trip> entry : this.getTravelOption().entrySet()) {
                Travelers traveler = entry.getKey();
                Trip trip = entry.getValue();
                System.out.println("Voyageur : " + traveler.getLivingCity().getName());
                System.out.println("Départ : " + trip.getDepartureCity().getName());
                System.out.println("Arrivée : " + trip.getArrivalCity().getName());
                System.out.println("Distance : " + trip.getDistance());
                System.out.println("CO2 généré (en kg): " + this.getCO2());
                System.out.println("Mode de transport : " + trip.getModeOfTransport().getTransportName());
                System.out.println("-----");
            }
    }
}
