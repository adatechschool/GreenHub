package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {
    @JsonProperty("geojson")
    public Geojson getGeojson() {
        return this.geojson; }

    Geojson geojson;

    public int getDistance() {
        return (geojson != null) ? geojson.getDistance() : 0;
    }
}
