package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Journey{
    @JsonProperty("duration")
    public int getDuration() {
        return this.duration; }
    int duration;
    @JsonProperty("co2_emission")
    public Co2Emission getCo2_emission() {
        return this.co2_emission; }
    Co2Emission co2_emission;

    @JsonProperty("sections")
    public ArrayList<Section> getSections() {
        return this.sections; }
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections; }
    ArrayList<Section> sections;

    public int totalDistance() {
        int distance = 0;
        for (Section section : sections) {
            distance += section.getDistance();
        }
        return distance;
    }
}