package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Co2Emission{
    @JsonProperty("value")
    public double getValue() {
        return this.value; }
    public void setValue(double value) {
        this.value = value; }
    double value;
    @JsonProperty("unit")
    public String getUnit() {
        return this.unit; }
    public void setUnit(String unit) {
        this.unit = unit; }
    String unit;
}