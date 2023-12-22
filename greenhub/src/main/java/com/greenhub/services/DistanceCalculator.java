package com.greenhub.services;

import com.greenhub.models.City;

public class DistanceCalculator {

    // Fonction pour convertir les degrés en radians
    private static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    // Calcul de la distance à vol d'oiseau entre deux points géographiques en kilomètres
    public static double calculateDistance(City origin, City destination) {
        final int R = 6371; // Rayon de la Terre en kilomètres

        double latDistance = degreesToRadians(destination.getX() - origin.getX());
        double lonDistance = degreesToRadians(destination.getY() - origin.getY());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(degreesToRadians(origin.getX())) * Math.cos(degreesToRadians(destination.getX()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // Distance en kilomètres
    }

}