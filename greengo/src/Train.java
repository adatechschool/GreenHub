public class Train implements ModeOfTransport{
    private final String transportName = "Train";
    private final int CO2EmissionPerKilometer = 4;

    public String getTransportName() {
        return this.transportName;
    }
    public int getCO2PerKilometer() {
        return this.CO2EmissionPerKilometer;
    }
}
