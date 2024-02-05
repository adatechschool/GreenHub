package com.greenhub.controllers;


import ch.qos.logback.core.model.Model;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.greenhub.models.City;
import com.greenhub.models.GlobalTravelOption;
import com.greenhub.models.Travelers;
import com.greenhub.models.Trip;
import com.greenhub.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/bestoption")
public class GlobalController {

    private final PlaneService planeService;
    private final TrainService trainService;
    private final CarService carService;

    @Autowired
    public GlobalController(PlaneService planeService, TrainService trainService, CarService carService) {
        this.planeService = planeService;
        this.trainService = trainService;
        this.carService = carService;
    }

    @GetMapping("/test")
    public ArrayList<GlobalTravelOption> getBestOption() throws JsonProcessingException {
        int maxTravelTime = 330;
        Travelers nantais1 = new Travelers("Lolo/Med/Dorniol", buildCityFromString("Nantes,47.2176116889171,-1.5412401068009252,NTE"), 3, maxTravelTime, 1000);
        Travelers nantais2 = new Travelers("Anast/Guitouf", buildCityFromString("Nantes,47.2176116889171,-1.5412401068009252,NTE"), 3, maxTravelTime, 1000);
        Travelers lyonnais = new Travelers("Mel/Raf/Anaïs/Raf", buildCityFromString("Lyon,45.76606462763691,4.83272363442929,LYS"), 5, maxTravelTime, 1000);
        Travelers parisiens = new Travelers("Camille/Titi", buildCityFromString("Paris,48.84110341748926,2.3220227046059105,CDG"), 2, maxTravelTime, 1000);
        Travelers bordelais = new Travelers("Anaïs/Michel", buildCityFromString("Bordeaux,44.82529325038888,-0.5562017943285817,BOD"), 2, maxTravelTime, 1000);
        Travelers toulousains = new Travelers("Helo/Alex", buildCityFromString("Toulouse,43.61133885593007,1.4543164961156636,TLS"), 3, maxTravelTime, 1000);
        Travelers marseillais = new Travelers("Marseillais", buildCityFromString("Marseille,43.4392719243989,5.221409633226013,MRS"), 2, maxTravelTime, 1000);
        Travelers lillois = new Travelers("Lillois", buildCityFromString("Lille,50.5639523849716,3.087746987915039,LTQ"), 2, maxTravelTime, 1000);
        Travelers strasbourgeois = new Travelers("Strasbourgeois", buildCityFromString("Strasbourg,48.539425,7.627089,STR"), 2, maxTravelTime, 1000);
        Travelers brestois = new Travelers("Brestois", buildCityFromString("Brest,48.447856, -4.418694,BES"), 2, maxTravelTime, 1000);
        Travelers aixois = new Travelers("Yas/JB", buildCityFromString("Aix-en-Provence,43.45639769931911, 5.316033170203662,MRS"), 3, maxTravelTime, 1000);
        Travelers compiégnois = new Travelers("Sonia/Axel", buildCityFromString("Compiègne,49.4175, 2.826389,CDG"), 3, maxTravelTime, 1000);
        Travelers toto = new Travelers("Toto", buildCityFromString("Reims,49.258329, 4.031696,CDG"), 1, maxTravelTime, 1000);
        Travelers pedro = new Travelers("Pedro", buildCityFromString("Paris,48.84110341748926,2.3220227046059105,CDG"), 1, maxTravelTime, 1000);
        Travelers mehdi = new Travelers("Mehdi", buildCityFromString("Nantes,47.2176116889171,-1.5412401068009252,NTE"), 1, maxTravelTime, 1000);
        Travelers nantes = new Travelers("Nantes", buildCityFromString("Nantes,47.2176116889171,-1.5412401068009252,NTE"), 1, maxTravelTime, 1000);
        Travelers dijon = new Travelers("Dijon", buildCityFromString("Dijon,47.32301605689184,5.027142558968659,DIJ"), 1, maxTravelTime, 1000);
        Travelers perpignan = new Travelers("Perpignan", buildCityFromString("Perpignan,42.696697424153996,2.8802255331151128,PGF"), 1, maxTravelTime, 1000);
        Travelers hamburg = new Travelers("Hambourg", buildCityFromString("Hambourg,53.553224146546064,9.953874351168654,HAM"), 2, maxTravelTime, 1000);

        Travelers[] copainsDuLycee = {mehdi, pedro, toto};
        Travelers[] copainsDuG7 = {nantais1, nantais2, compiégnois, aixois};
        Travelers[] copainsDuBresil = {nantais1, lyonnais, toulousains, bordelais, hamburg};
        Travelers[] copainsdeValentin = {nantes, perpignan, dijon};

        City[] destinations = CityLoader.loadCitiesFromCSV("/Users/mehdigrimault/Desktop/Ada/FakeGreenGo/greenhub/src/main/java/com/greenhub/repository/cities.csv");

        ArrayList<Trip> allTrips = new ArrayList<>();
        for (City destination : destinations) {
            boolean destinationHasOption = true;

            for (Travelers traveler : copainsdeValentin) {
                if (destinationHasOption) {
                    // call to train service
                    Trip trainTrip = trainService.getTrainTrip(traveler.getLivingCity(), destination);
                    // add the train trip if it exists and the travel time is valid
                    if (trainTrip != null && trainTrip.getTravelTime() < maxTravelTime) {
                        allTrips.add(trainTrip);
                    }

                    else {
                        // estimate the distance between the two cities
                        int distance = (int) DistanceCalculator.calculateDistance(traveler.getLivingCity(), destination);
                        // check if a car trip should be possible regarding distance, max speed and max travel time
                        if (distance < maxTravelTime * 110 / 60) {
                            // call to car service
                            Trip carTrip = carService.getCarTrip(traveler.getLivingCity(), destination);
                            // add the car trip if it exists and the travel time is valid
                            if (carTrip != null && carTrip.getTravelTime() < maxTravelTime) {
                                allTrips.add(carTrip);
                                //if a car trip is possible, call the plane service only if nb of travelers < 3
                                if (traveler.getNumberOfTravelers() < 3) {
                                    // call to plane service
                                    Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                                    // add the plane trip if it exists and the travel time is valid
                                    if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                        allTrips.add(planeTrip);
                                    }
                                }
                            }
                            else {
                                // call to plane service
                                Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                                // add the plane trip if it exists and the travel time is valid
                                if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                    allTrips.add(planeTrip);
                                }
                                if (planeTrip == null) {
                                    destinationHasOption = false;
                                }
                            }
                        }
                        else {
                            // call to plane service
                            Trip planeTrip = planeService.getPlaneTrip(traveler.getLivingCity(), destination);
                            // add the plane trip if it exists and the travel time is valid
                            if (planeTrip != null && planeTrip.getTravelTime() < maxTravelTime) {
                                allTrips.add(planeTrip);
                            }
                            if (planeTrip == null) {
                                destinationHasOption = false;
                            }
                        }
                    }
                }
            }

        }

        ArrayList<GlobalTravelOption> bestOptions = BestTravelOptionService.getLowestCo2Option(copainsdeValentin, destinations, allTrips);

        // Afficher les informations sur les meilleures options dans la console
        System.out.println("Top 5 meilleures destinations :");
        int count = Math.min(bestOptions.size(), 5); // Prendre les 3 premières, ou moins si moins de 3 options
        for (int i = 0; i < count; i++) {
            GlobalTravelOption option = bestOptions.get(i);
            System.out.println("Destination " + (i + 1) + ": " + option.getDestination() +
                    " - Émission de CO2 (en kg): " + option.getCO2Quantity() / 1000);
        }
        System.out.println("-----");

        if (!bestOptions.isEmpty()) {
            for (int i = 0; i < count; i++) {
                bestOptions.get(i).print();
            }
        } else {
            System.out.println("Aucune option de voyage trouvée pour le groupe.");
        }

        return bestOptions;
    }


    private City buildCityFromString(String string) {
        String[] values = string.split(",");
        String cityName = values[0];
        float cityX = Float.parseFloat(values[1]);
        float cityY = Float.parseFloat(values[2]);
        String iataCode = values[3];
        return new City(cityName, cityX, cityY, iataCode);
    }
}