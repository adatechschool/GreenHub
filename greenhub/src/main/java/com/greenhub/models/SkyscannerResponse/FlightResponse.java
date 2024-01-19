package com.greenhub.models.SkyscannerResponse;

public class FlightResponse{
    public Content content;

    public static class Content{
        public Stats stats;
        public class Stats{
            public Itineraries itineraries;

            public class Itineraries{
                public int minDuration;

                public int getMinDuration() {
                    return minDuration;
                }
            }
        }
    }
}
