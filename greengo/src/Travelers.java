public class Travelers {
    private String livingCity;
    private int numberOfTravelers;

    // Constructeur
    public Travelers(String livingCity,int numberOfTravelers) {
        this.livingCity = livingCity;
        this.numberOfTravelers = numberOfTravelers;
    }

    public String getLivingCity() {
        return livingCity;
    }
    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }
}
