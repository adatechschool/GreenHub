import java.lang.Math;

public class Trip {
    private City departureCity;
    private City arrivalCity;
    private int distance;

    private String modeOfTransport;

    // Constructeur
    public Trip(City departureCity, City arrivalCity, int distance) {
        // qd on aura des coordonnes changer le param distance en une méthode getDistance qui calculera la d selon les coord.
        // les
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distance = distance;
    }

    public City getDepartureCity() {
        return departureCity;
    }
    public City getArrivalCity() {
        return arrivalCity;
    }
    public int getDistance() {
        return distance;
    }

    public int getCO2 (){
        return Math.round(this.distance * 285 / 1000);
    };
}
