import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);

    public static Travelers traveler1 = new Travelers(nantes,1);
    public static Travelers traveler2 = new Travelers(lyon,1);
    public static Travelers traveler3 = new Travelers(paris,1);

    public static Travelers groupOfTravelers[] = {traveler1,traveler2,traveler3};



    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            System.out.println(groupOfTravelers[i].getLivingCity().getName());
        };
    }


    public static HashMap<City,Integer> getLowestCO2Destination( ArrayList<Travelers> groupOfTravelers) {
        HashMap<City,Integer> result = new HashMap<>();
        result.put(Main.paris, 300);
        return result;
    }
}