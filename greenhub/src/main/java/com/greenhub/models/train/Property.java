package com.greenhub.models.train;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
    @JsonProperty("length")
    public int getLength() {
        return this.length;
    }
    int length;
}

