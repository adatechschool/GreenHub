package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Co2Emission{
    @JsonProperty("value")
    public double getValue() {
        return this.value; }
    double value;
}