import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void getCO2() {
        Trip myTrip = new Trip("Nantes","Lyon",538);
        Assert.assertEquals(myTrip.getCO2(), 153);
    }
    @Test
    public String getLowestCO2Destination() {
        // pour 1 voyageur calculer les émissions de CO2 pour chaque destinations
        // entrée: un voyageur
        // parcourir la liste des destinations qui co

    }
    // fonction: pour chaque destination faire la somme des emissions de CO2 de tous les voyageurs & retourner la destination la + économe en C02

}