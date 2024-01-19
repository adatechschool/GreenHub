package com.greenhub.models.apis.plane;

public class PlaneTrips {
    public Content content;

    public static class Content{
        public Stats stats;
        public static class Stats{
            public Itineraries itineraries;

            public static class Itineraries{
                public int minDuration;

                public int getMinDuration() {
                    return this.minDuration;
                }
            }
        }
    }
}
