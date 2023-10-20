import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);
    public static City bordeaux = new City("Bordeaux", 0, 0);
    public static City toulouse = new City("Toulouse", 0, 0);

    public static City allCities[] = {nantes,lyon,paris,bordeaux,toulouse};

    /*-----------------*/

    public static ModeOfTransport plane = new Plane();
    
    /*-----------------*/

    public static Trip trip1 = new Trip(nantes,nantes,0, plane);
    public static Trip trip2 = new Trip(nantes,lyon,538, plane);
    public static Trip trip3 = new Trip(nantes,paris,372, plane);
    public static Trip trip4 = new Trip(nantes,bordeaux,267, plane);
    public static Trip trip5 = new Trip(nantes,toulouse,455, plane);

    /*-----------------*/

    public static Trip trip6 = new Trip(lyon,nantes,538, plane);
    public static Trip trip7 = new Trip(lyon,lyon,0, plane);
    public static Trip trip8 = new Trip(lyon,paris,412, plane);
    public static Trip trip9 = new Trip(lyon,bordeaux,465, plane);
    public static Trip trip10 = new Trip(lyon,toulouse,375, plane);


    /*-----------------*/
    public static Trip trip11 = new Trip(paris,nantes,372, plane);
    public static Trip trip12 = new Trip(paris,lyon,412, plane);
    public static Trip trip13 = new Trip(paris,paris,0, plane);
    public static Trip trip14 = new Trip(paris,bordeaux,526, plane);
    public static Trip trip15 = new Trip(paris,toulouse,604, plane);

    /*-----------------*/

    public static Trip trip16 = new Trip(bordeaux,nantes,267, plane);
    public static Trip trip17 = new Trip(bordeaux,lyon,465, plane);
    public static Trip trip18 = new Trip(bordeaux,paris,526, plane);
    public static Trip trip19 = new Trip(bordeaux,toulouse,213, plane);
    public static Trip trip20 = new Trip(bordeaux,bordeaux,0, plane);

    /*-----------------*/

    public static Trip trip21 = new Trip(toulouse,paris,604, plane);
    public static Trip trip22 = new Trip(toulouse,nantes,455, plane);
    public static Trip trip23 = new Trip(toulouse,lyon,375, plane);
    public static Trip trip24 = new Trip(toulouse,toulouse,0, plane);
    public static Trip trip25 = new Trip(toulouse,bordeaux,213, plane);

    public static ModeOfTransport car = new Car();

    /*-----------------*/

    public static Trip tripCar1 = new Trip(nantes,nantes,0, car);
    public static Trip tripCar2 = new Trip(nantes,lyon,538, car);
    public static Trip tripCar3 = new Trip(nantes,paris,372, car);
    public static Trip tripCar4 = new Trip(nantes,bordeaux,267, car);
    public static Trip tripCar5 = new Trip(nantes,toulouse,455, car);

    /*-----------------*/

    public static Trip tripCar6 = new Trip(lyon,nantes,538, car);
    public static Trip tripCar7 = new Trip(lyon,lyon,0, car);
    public static Trip tripCar8 = new Trip(lyon,paris,412, car);
    public static Trip tripCar9 = new Trip(lyon,bordeaux,465, car);
    public static Trip tripCar10 = new Trip(lyon,toulouse,375, car);


    /*-----------------*/
    public static Trip tripCar11 = new Trip(paris,nantes,372, car);
    public static Trip tripCar12 = new Trip(paris,lyon,412, car);
    public static Trip tripCar13 = new Trip(paris,paris,0, car);
    public static Trip tripCar14 = new Trip(paris,bordeaux,526, car);
    public static Trip tripCar15 = new Trip(paris,toulouse,604, car);

    /*-----------------*/

    public static Trip tripCar16 = new Trip(bordeaux,nantes,267, car);
    public static Trip tripCar17 = new Trip(bordeaux,lyon,465, car);
    public static Trip tripCar18 = new Trip(bordeaux,paris,526, car);
    public static Trip tripCar19 = new Trip(bordeaux,toulouse,213, car);
    public static Trip tripCar20 = new Trip(bordeaux,bordeaux,0, car);

    /*-----------------*/

    public static Trip tripCar21 = new Trip(toulouse,paris,604, car);
    public static Trip tripCar22 = new Trip(toulouse,nantes,455, car);
    public static Trip tripCar23 = new Trip(toulouse,lyon,375, car);
    public static Trip tripCar24 = new Trip(toulouse,toulouse,0, car);
    public static Trip tripCar25 = new Trip(toulouse,bordeaux,213, car);

    public static ModeOfTransport train = new Train();

    /*-----------------*/

    public static Trip tripTrain1 = new Trip(nantes,nantes,0, train);
    public static Trip tripTrain2 = new Trip(nantes,lyon,538, train);
    public static Trip tripTrain3 = new Trip(nantes,paris,372, train);
    public static Trip tripTrain4 = new Trip(nantes,bordeaux,267, train);
    public static Trip tripTrain5 = new Trip(nantes,toulouse,455, train);

    /*-----------------*/

    public static Trip tripTrain6 = new Trip(lyon,nantes,538, train);
    public static Trip tripTrain7 = new Trip(lyon,lyon,0, train);
    public static Trip tripTrain8 = new Trip(lyon,paris,412, train);
    public static Trip tripTrain9 = new Trip(lyon,bordeaux,465, train);
    public static Trip tripTrain10 = new Trip(lyon,toulouse,375, train);


    /*-----------------*/
    public static Trip tripTrain11 = new Trip(paris,nantes,372, train);
    public static Trip tripTrain12 = new Trip(paris,lyon,412, train);
    public static Trip tripTrain13 = new Trip(paris,paris,0, train);
    public static Trip tripTrain14 = new Trip(paris,bordeaux,526, train);
    public static Trip tripTrain15 = new Trip(paris,toulouse,604, train);

    /*-----------------*/

    public static Trip tripTrain16 = new Trip(bordeaux,nantes,267, train);
    public static Trip tripTrain17 = new Trip(bordeaux,lyon,465, train);
    public static Trip tripTrain18 = new Trip(bordeaux,paris,526, train);
    public static Trip tripTrain19 = new Trip(bordeaux,toulouse,213, train);
    public static Trip tripTrain20 = new Trip(bordeaux,bordeaux,0, train);

    /*-----------------*/

    public static Trip tripTrain21 = new Trip(toulouse,paris,604, train);
    public static Trip tripTrain22 = new Trip(toulouse,nantes,455, train);
    public static Trip tripTrain23 = new Trip(toulouse,lyon,375, train);
    public static Trip tripTrain24 = new Trip(toulouse,toulouse,0, train);
    public static Trip tripTrain25 = new Trip(toulouse,bordeaux,213, train);

    
    public static Trip allTrips[] = {trip1,trip2,trip3,trip4,trip5,trip6,trip7,trip8,trip9,trip10,trip11,trip12,trip13,trip14,trip15,trip16,trip17,trip18,trip19,trip20,trip21,trip22,trip23,trip24,trip25,
            tripCar1,tripCar2,tripCar3,tripCar4,tripCar5,tripCar6,tripCar7,tripCar8,tripCar9,tripCar10,tripCar11,tripCar12,tripCar13,tripCar14,tripCar15,tripCar16,tripCar17,tripCar18,tripCar19,tripCar20,tripCar21,tripCar22,tripCar23,tripCar24,tripCar25,
            tripTrain1,tripTrain2,tripTrain3,tripTrain4,tripTrain5,tripTrain6,tripTrain7,tripTrain8,tripTrain9,tripTrain10,tripTrain11,tripTrain12,tripTrain13,tripTrain14,tripTrain15,tripTrain16,tripTrain17,tripTrain18,tripTrain19,tripTrain20,tripTrain21,tripTrain22,tripTrain23,tripTrain24,tripTrain25};

    public static Travelers traveler1 = new Travelers(nantes,4);
    public static Travelers traveler2 = new Travelers(lyon,3);
    public static Travelers traveler3 = new Travelers(paris,4);
    public static Travelers traveler4 = new Travelers(bordeaux,2);
    public static Travelers traveler5 = new Travelers(toulouse,3);

    public static Travelers groupOfTravelers[] = {traveler1,traveler2,traveler3,traveler4,traveler5};


    public static void main(String[] args) {
        GlobalTravelOption bestTravelOption = getLowestCO2Option(groupOfTravelers);
        bestTravelOption.print();

    }


    public static GlobalTravelOption getLowestCO2Option(Travelers [] groupOfTravelers) {
        //create an arrayList to store the best options for each destination
        ArrayList<GlobalTravelOption> possibleOptions = new ArrayList<>();
        for (City destination : allCities) {
            //Create an arraylist of hashmaps which associate the travelers to a trip option
            ArrayList<TravelOption> bestOptionPerDestination = new ArrayList<>();
            for (Travelers traveler : groupOfTravelers) {
                //get the best option regarding CO2 for a traveler
                Trip bestOptionPerTravelerPerDestination = traveler.getBestOptionPerDestination(destination);
                //store it in a hashmap and then in the bestOptionPerCity array
                TravelOption travelOption = new TravelOption(traveler, bestOptionPerTravelerPerDestination);
                bestOptionPerDestination.add(travelOption);

            }
            GlobalTravelOption globalTravelOption = new GlobalTravelOption(bestOptionPerDestination);
            possibleOptions.add(globalTravelOption);
        }
        //loop into the possible options and keep the one with the lowest CO2 emission
        int minCO2 = Integer.MAX_VALUE; // Initialisation avec une valeur très élevée
        GlobalTravelOption bestOption = null;

        for (GlobalTravelOption option : possibleOptions) {
            int totalCO2=0;
            for (TravelOption travelOption : option.getGlobalTravelOption()) {
                totalCO2 += travelOption.getCO2();
            }
            if (totalCO2 < minCO2) {
                minCO2 = totalCO2;
                bestOption = option;
            }
        }
        return bestOption;
    }

    }
