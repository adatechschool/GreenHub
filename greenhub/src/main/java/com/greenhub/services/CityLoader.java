package com.greenhub.services;

import com.greenhub.models.City;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Repository
public class CityLoader {
    public static City[] loadCitiesFromCSV(String filePath) {
        City[] cities = new City[9]; // Définir la taille du tableau

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skipping the header
            br.readLine();

            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                float latitude = Float.parseFloat(values[1]);
                float longitude = Float.parseFloat(values[2]);
                String iataCode = values[3];
                City city = new City(name, latitude, longitude, iataCode);
                cities[index++] = city;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
