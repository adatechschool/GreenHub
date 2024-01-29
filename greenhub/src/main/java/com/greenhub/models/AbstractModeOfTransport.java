package com.greenhub.models;

public abstract  class AbstractModeOfTransport implements  ModeOfTransport{

    private final String transportName;
    private final int CO2EmissionPerKilometer;

    public AbstractModeOfTransport(String transportName, int CO2EmissionPerKilometer){
        this.transportName = transportName;
        this.CO2EmissionPerKilometer = CO2EmissionPerKilometer;

    }
    public String getTransportName() {
        return this.transportName;
    }
    public int getCO2PerKilometer() {
        return this.CO2EmissionPerKilometer;
    }

}
