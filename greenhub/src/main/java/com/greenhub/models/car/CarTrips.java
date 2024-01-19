package com.greenhub.models.car;

import java.util.ArrayList;


public class CarTrips{

    public ArrayList<Feature> features;
    static public class Feature {
        public Properties properties;

        static public class Properties{
            public ArrayList<Segment> segments;

            static public class Segment{
                public double distance;

                public int getDistance() {return (int)Math.round(this.distance);}
                public double duration;

                public int getDuration() {return (int)Math.round(this.duration);}

            }
        }
    }
}




