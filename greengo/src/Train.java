public class Train implements ModeOfTransport{
    private final String transportName = "Train";
    private final int CO2EmissionPerKilometer = 4;

    public int getCO2PerKilometer() {
        return this.CO2EmissionPerKilometer;
    }
}
