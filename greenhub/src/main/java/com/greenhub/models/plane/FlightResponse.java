package com.greenhub.models.plane;

import java.time.ZonedDateTime;

public class FlightResponse {
    private Pagination pagination;
    private FlightData[] data;

    public FlightData[] getData() {
        return this.data;
    }

}

