package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geojson{
    @JsonProperty("properties")
    public ArrayList<Property> getProperties() {
        return this.properties; }
    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties; }
    ArrayList<Property> properties;

    public int getDistance () {
        int distance = 0;
        for (Property property : properties) {
            distance += property.getLength();
        }
        return distance;
    }
}