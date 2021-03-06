package ohtu.verkkokauppa;

import ohtu.rajapinnat.Kirjanpito;
import ohtu.rajapinnat.Pankki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PankkiImpl implements Pankki {
    private Kirjanpito kirjanpito;

    @Autowired
    public PankkiImpl(Kirjanpito kp) {
        kirjanpito = kp;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
