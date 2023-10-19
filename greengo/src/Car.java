public class Car implements ModeOfTransport{
    private final String transportName = "Car";
    private final int CO2EmissionPerKilometer = 217;

    public int getCO2PerKilometer() {
        return this.CO2EmissionPerKilometer;
    }
}
