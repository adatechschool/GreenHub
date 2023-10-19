public class Plane implements ModeOfTransport{
    private final String transportName = "Plane";
    private final int CO2EmissionPerKilometer = 285;

    public int getCO2PerKilometer() {
        return this.CO2EmissionPerKilometer;
    }
}