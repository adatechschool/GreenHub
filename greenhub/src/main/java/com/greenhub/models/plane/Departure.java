package com.greenhub.models.plane;

public class Departure {
    private String airport;
    private String iata;
    private String scheduled;

    public CharSequence getScheduled() {
        return this.scheduled;
    }
}
