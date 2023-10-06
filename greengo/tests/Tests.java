import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void getCO2() {
        Trip myTrip = new Trip("Nantes","Lyon",538);
        Assert.assertEquals(myTrip.getCO2(), 153);
    }
}