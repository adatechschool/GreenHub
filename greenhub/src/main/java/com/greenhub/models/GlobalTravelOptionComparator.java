package com.greenhub.models;

import java.util.Comparator;

public class GlobalTravelOptionComparator implements Comparator<GlobalTravelOption> {
    @Override
    public int compare(GlobalTravelOption travelOption1, GlobalTravelOption travelOption2) {
        return Integer.compare(travelOption1.getCO2Quantity(), travelOption2.getCO2Quantity());
    }
}