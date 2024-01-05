package com.greenhub.models.plane;

public class FlightData {
    private String flight_date;
    private String flight_status;
    private Departure departure;
    private Arrival arrival;

    public Departure getDeparture() {
        return this.departure;
    }

    public Arrival getArrival() {
        return this.arrival;
    }

    // Getters and setters
}
