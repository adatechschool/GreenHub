import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GlobalTravelOption {
    private ArrayList<TravelOption> globalTravelOption;

    public GlobalTravelOption(ArrayList<TravelOption> globalTravelOption ) {
        this.globalTravelOption = globalTravelOption;
    }

    public int getCO2Quantity() {
        int CO2quantity = 0;
        for (TravelOption travelOption : this.globalTravelOption) {
            CO2quantity += travelOption.getCO2();
        }
        return CO2quantity;
    }

    public String getDestination() {
        return globalTravelOption.get(0).getTrip().getArrivalCity().getName();
    }

    public ArrayList<TravelOption> getGlobalTravelOption() {
        return this.globalTravelOption;
    }

    public void print() {
        System.out.println("Pour minimiser l'empreinte carbone du groupe, il faudrait aller à : " + this.getDestination());
        System.out.println("CO2 généré au total (en kg): " + this.getCO2Quantity());
        System.out.println("Détails de l'option de voyage pour tous les voyageurs:");
        for (TravelOption travelOption : this.globalTravelOption) {
           travelOption.print();
        }
    }

}

