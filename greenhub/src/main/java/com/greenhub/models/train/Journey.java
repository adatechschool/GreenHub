package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
}