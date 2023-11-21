package com.greenhub.models.train;
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

}

