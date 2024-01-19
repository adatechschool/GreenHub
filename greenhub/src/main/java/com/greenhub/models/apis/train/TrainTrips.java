package com.greenhub.models.apis.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainTrips {
    @JsonProperty("journeys")
    public ArrayList<Journey> getJourneys() {
        return this.journeys; }
    public void setJourneys(ArrayList<Journey> journeys) {
        this.journeys = journeys; }
    ArrayList<Journey> journeys;

    public static class Journey{
        @JsonProperty("duration")
        public int getDuration() {
            return this.duration; }
        int duration;
        @JsonProperty("co2_emission")
        public Co2Emission getCo2_emission() {
            return this.co2_emission; }
        Co2Emission co2_emission;

        public static class Co2Emission{
            @JsonProperty("value")
            public double getValue() {
                return this.value; }
            double value;
        }

        @JsonProperty("sections")
        public ArrayList<Section> getSections() {
            return this.sections; }
        public void setSections(ArrayList<Section> sections) {
            this.sections = sections; }
        ArrayList<Section> sections;

        public static class Section {
            @JsonProperty("geojson")
            public Geojson getGeojson() {
                return this.geojson; }

            Geojson geojson;

            public int getDistance() {
                return (geojson != null) ? geojson.getDistance() : 0;
            }

            public static class Geojson{
                @JsonProperty("properties")
                public ArrayList<Property> getProperties() {
                    return this.properties; }
                public void setProperties(ArrayList<Property> properties) {
                    this.properties = properties; }
                ArrayList<Property> properties;

                public static class Property {
                    @JsonProperty("length")
                    public int getLength() {
                        return this.length;
                    }
                    int length;
                }


                public int getDistance () {
                    int distance = 0;
                    for (Property property : properties) {
                        distance += property.getLength();
                    }
                    return distance;
                }
            }
        }

        public int totalDistance() {
            int distance = 0;
            for (Section section : sections) {
                distance += section.getDistance();
            }
            return distance;
        }
    }

}

