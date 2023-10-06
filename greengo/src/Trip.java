import java.lang.Math;

public class Trip {
    private String departureCity;
    private String arrivalCity;
    private int distance;

    // Constructeur
    public Trip(String departureCity, String arrivalCity, int distance) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distance = distance;
    }

    public String getDepartureCity() {
        return departureCity;
    }
    public String getArrivalCity() {
        return arrivalCity;
    }
    public int getDistance() {
        return distance;
    }

    public int getCO2 (){
        return Math.round(this.distance * 285 / 1000);
    };
}
