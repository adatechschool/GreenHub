package com.greenhub;

import com.greenhub.models.*;
import com.greenhub.services.CarService;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class Main implements CommandLineRunner {
    public static City nantes = new City("Nantes", 0, 0);
    public static City lyon = new City("Lyon", 0, 0);
    public static City paris = new City("Paris", 0, 0);
    public static City bordeaux = new City("Bordeaux", 0, 0);
    public static City toulouse = new City("Toulouse", 0, 0);

    public static City[] allCities = {paris, nantes, lyon, bordeaux, toulouse};

    /*-----------------*/

    public static ModeOfTransport plane = new Plane();

    /*-----------------*/

    public static Trip trip1 = new Trip(nantes, nantes, 0, plane, 0, 0);
    public static Trip trip2 = new Trip(nantes, lyon, 538, plane, 75, 66);
    public static Trip trip3 = new Trip(nantes, paris, 372, plane, 65, 104);
    public static Trip trip4 = new Trip(nantes, bordeaux, 267, plane, 195, 205);
    public static Trip trip5 = new Trip(nantes, toulouse, 455, plane, 70, 61);

    /*-----------------*/

    public static Trip trip6 = new Trip(lyon, nantes, 538, plane, 75, 66);
    public static Trip trip7 = new Trip(lyon, lyon, 0, plane, 0, 0);
    public static Trip trip8 = new Trip(lyon, paris, 412, plane, 70, 104);
    public static Trip trip9 = new Trip(lyon, bordeaux, 465, plane, 70, 120);
    public static Trip trip10 = new Trip(lyon, toulouse, 375, plane, 65, 110);


    /*-----------------*/
    public static Trip trip11 = new Trip(paris, nantes, 372, plane, 65, 104);
    public static Trip trip12 = new Trip(paris, lyon, 412, plane, 70, 104);
    public static Trip trip13 = new Trip(paris, paris, 0, plane, 0, 0);
    public static Trip trip14 = new Trip(paris, bordeaux, 526, plane, 75, 137);
    public static Trip trip15 = new Trip(paris, toulouse, 604, plane, 80, 147);

    /*-----------------*/

    public static Trip trip16 = new Trip(bordeaux, nantes, 267, plane, 75, 137);
    public static Trip trip17 = new Trip(bordeaux, lyon, 465, plane, 70, 120);
    public static Trip trip18 = new Trip(bordeaux, paris, 526, plane, 85, 146);
    public static Trip trip19 = new Trip(bordeaux, toulouse, 213, plane, 240, 147);
    public static Trip trip20 = new Trip(bordeaux, bordeaux, 0, plane, 0, 0);

    /*-----------------*/

    public static Trip trip21 = new Trip(toulouse, paris, 604, plane, 80, 147);
    public static Trip trip22 = new Trip(toulouse, nantes, 455, plane, 70, 54);
    public static Trip trip23 = new Trip(toulouse, lyon, 375, plane, 60, 95);
    public static Trip trip24 = new Trip(toulouse, toulouse, 0, plane, 0, 0);
    public static Trip trip25 = new Trip(toulouse, bordeaux, 213, plane, 240, 147);

    public static ModeOfTransport car = new Car();

    /*-----------------*/

    public static Trip tripCar1 = new Trip(nantes, nantes, 0, car, 0, 0);
    public static Trip tripCar2 = new Trip(nantes, lyon, 645, car, 420, 123);
    public static Trip tripCar3 = new Trip(nantes, paris, 381, car, 232, 81);
    public static Trip tripCar4 = new Trip(nantes, bordeaux, 316, car, 208, 73);
    public static Trip tripCar5 = new Trip(nantes, toulouse, 554, car, 342, 112);

    /*-----------------*/

    public static Trip tripCar6 = new Trip(lyon, nantes, 645, car, 420, 123);
    public static Trip tripCar7 = new Trip(lyon, lyon, 0, car, 0, 0);
    public static Trip tripCar8 = new Trip(lyon, paris, 463, car, 273, 92);
    public static Trip tripCar9 = new Trip(lyon, bordeaux, 533, car, 344, 108);
    public static Trip tripCar10 = new Trip(lyon, toulouse, 540, car, 315, 118);


    /*-----------------*/
    public static Trip tripCar11 = new Trip(paris, nantes, 381, car, 232, 81);
    public static Trip tripCar12 = new Trip(paris, lyon, 463, car, 273, 92);
    public static Trip tripCar13 = new Trip(paris, paris, 0, car, 0, 0);
    public static Trip tripCar14 = new Trip(paris, bordeaux, 583, car, 336, 125);
    public static Trip tripCar15 = new Trip(paris, toulouse, 676, car, 398, 118);

    /*-----------------*/

    public static Trip tripCar16 = new Trip(bordeaux, nantes, 316, car, 208, 73);
    public static Trip tripCar17 = new Trip(bordeaux, lyon, 533, car, 344, 108);
    public static Trip tripCar18 = new Trip(bordeaux, paris, 583, car, 336, 125);
    public static Trip tripCar19 = new Trip(bordeaux, toulouse, 244, car, 150, 50);
    public static Trip tripCar20 = new Trip(bordeaux, bordeaux, 0, car, 0, 0);

    /*-----------------*/

    public static Trip tripCar21 = new Trip(toulouse, paris, 676, car, 398, 118);
    public static Trip tripCar22 = new Trip(toulouse, nantes, 554, car, 342, 112);
    public static Trip tripCar23 = new Trip(toulouse, lyon, 540, car, 315, 118);
    public static Trip tripCar24 = new Trip(toulouse, toulouse, 0, car, 0, 0);
    public static Trip tripCar25 = new Trip(toulouse, bordeaux, 244, car, 150, 50);

    public static ModeOfTransport train = new Train();

    /*-----------------*/

    public static Trip tripTrain1 = new Trip(nantes, nantes, 0, train, 0, 0);
    public static Trip tripTrain2 = new Trip(nantes, lyon, 538, train, 265, 84);
    public static Trip tripTrain3 = new Trip(nantes, paris, 372, train, 122, 45);
    public static Trip tripTrain4 = new Trip(nantes, bordeaux, 267, train, 253, 41);
    public static Trip tripTrain5 = new Trip(nantes, toulouse, 455, train, 396, 63);

    /*-----------------*/

    public static Trip tripTrain6 = new Trip(lyon, nantes, 538, train, 265, 84);
    public static Trip tripTrain7 = new Trip(lyon, lyon, 0, train, 0, 0);
    public static Trip tripTrain8 = new Trip(lyon, paris, 412, train, 116, 104);
    public static Trip tripTrain9 = new Trip(lyon, bordeaux, 465, train, 372, 107);
    public static Trip tripTrain10 = new Trip(lyon, toulouse, 375, train, 249, 92);


    /*-----------------*/
    public static Trip tripTrain11 = new Trip(paris, nantes, 372, train, 122, 45);
    public static Trip tripTrain12 = new Trip(paris, lyon, 412, train, 116, 104);
    public static Trip tripTrain13 = new Trip(paris, paris, 0, train, 0, 0);
    public static Trip tripTrain14 = new Trip(paris, bordeaux, 526, train, 143, 84);
    public static Trip tripTrain15 = new Trip(paris, toulouse, 604, train, 260, 86);

    /*-----------------*/

    public static Trip tripTrain16 = new Trip(bordeaux, nantes, 267, train, 253, 41);
    public static Trip tripTrain17 = new Trip(bordeaux, lyon, 465, train, 372, 107);
    public static Trip tripTrain18 = new Trip(bordeaux, paris, 526, train, 143, 84);
    public static Trip tripTrain19 = new Trip(bordeaux, toulouse, 213, train, 125, 22);
    public static Trip tripTrain20 = new Trip(bordeaux, bordeaux, 0, train, 0, 0);

    /*-----------------*/

    public static Trip tripTrain21 = new Trip(toulouse, paris, 604, train, 260, 86);
    public static Trip tripTrain22 = new Trip(toulouse, nantes, 455, train, 396, 63);
    public static Trip tripTrain23 = new Trip(toulouse, lyon, 375, train, 249, 92);
    public static Trip tripTrain24 = new Trip(toulouse, toulouse, 0, train, 0, 0);
    public static Trip tripTrain25 = new Trip(toulouse, bordeaux, 213, train, 125, 22);


    public static Trip[] allTrips = {trip1, trip2, trip3, trip4, trip5, trip6, trip7, trip8, trip9, trip10, trip11, trip12, trip13, trip14, trip15, trip16, trip17, trip18, trip19, trip20, trip21, trip22, trip23, trip24, trip25,
            tripCar1, tripCar2, tripCar3, tripCar4, tripCar5, tripCar6, tripCar7, tripCar8, tripCar9, tripCar10, tripCar11, tripCar12, tripCar13, tripCar14, tripCar15, tripCar16, tripCar17, tripCar18, tripCar19, tripCar20, tripCar21, tripCar22, tripCar23, tripCar24, tripCar25,
            tripTrain1, tripTrain2, tripTrain3, tripTrain4, tripTrain5, tripTrain6, tripTrain7, tripTrain8, tripTrain9, tripTrain10, tripTrain11, tripTrain12, tripTrain13, tripTrain14, tripTrain15, tripTrain16, tripTrain17, tripTrain18, tripTrain19, tripTrain20, tripTrain21, tripTrain22, tripTrain23, tripTrain24, tripTrain25};

    public static int maxTravelTime = 320;
    public static Travelers traveler1 = new Travelers("Nantais", nantes, 4, maxTravelTime, 1000);
    public static Travelers traveler2 = new Travelers("Lyonnais", lyon, 5, maxTravelTime, 1000);
    public static Travelers traveler3 = new Travelers("Parisiens", paris, 2, maxTravelTime, 1000);
    public static Travelers traveler4 = new Travelers("Bordelais", bordeaux, 2, maxTravelTime, 1000);
    public static Travelers traveler5 = new Travelers("Toulousains", toulouse, 3, maxTravelTime, 1000);

    public static Travelers[] groupOfTravelers = {traveler1, traveler2, traveler3, traveler4, traveler5};

    @Override
    public void run(String... args) throws Exception {
        GlobalTravelOption bestTravelOption = getLowestCO2Option(groupOfTravelers);
        bestTravelOption.print();

        //test
        System.out.print("test");
        CarService carService = new CarService();
        carService.getCarTrip("-1.5427562403976707,47.215594893836716","2.3208076325309848, 48.842281481558445");
    }


    public static GlobalTravelOption getLowestCO2Option(Travelers[] groupOfTravelers) {
        //create an arrayList to store the best options for each destination
        ArrayList<GlobalTravelOption> possibleOptions = new ArrayList<>();
        for (City destination : allCities) {
            //Create an arraylist of travelOption which associate the travelers to a trip option
            ArrayList<TravelOption> bestOptionPerDestination = new ArrayList<>();
            for (Travelers traveler : groupOfTravelers) {
                //get the best option regarding CO2 for a traveler
                Trip bestOptionPerTravelerPerDestination = traveler.getBestOptionPerDestination(destination);
                //store it in a travelOption object and then in the bestOptionPerDestination array
                TravelOption travelOption = new TravelOption(traveler, bestOptionPerTravelerPerDestination);
                bestOptionPerDestination.add(travelOption);

            }
            boolean possibleDestination = true;
            for (TravelOption travelOption : bestOptionPerDestination) {
                if (travelOption.getTrip() == null) {
                    possibleDestination = false;
                    break;
                }
            }
            if (possibleDestination) {
                GlobalTravelOption globalTravelOption = new GlobalTravelOption(bestOptionPerDestination);
                possibleOptions.add(globalTravelOption);
            }
        }
        //loop into the possible options and keep the one with the lowest CO2 emission
        int minCO2 = Integer.MAX_VALUE; // Initialisation avec une valeur très élevée
        GlobalTravelOption bestOption = null;

        for (GlobalTravelOption option : possibleOptions) {
            int totalCO2 = 0;
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
