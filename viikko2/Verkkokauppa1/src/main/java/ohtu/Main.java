package ohtu;

import ohtu.rajapinnat.Kirjanpito;
import ohtu.rajapinnat.Pankki;
import ohtu.rajapinnat.Varasto;
import ohtu.rajapinnat.Viitegeneraattori;
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.KirjanpitoImpl;
import ohtu.verkkokauppa.PankkiImpl;
import ohtu.verkkokauppa.VarastoImpl;
import ohtu.verkkokauppa.ViitegeneraattoriImpl;

public class Main {

    public static void main(String[] args) {
        KirjanpitoImpl kirjanpito = new KirjanpitoImpl();
        VarastoImpl varasto = new VarastoImpl(kirjanpito);
        PankkiImpl pankki = new PankkiImpl(kirjanpito);
        ViitegeneraattoriImpl viitegen = new ViitegeneraattoriImpl();
        
        Kauppa kauppa = new Kauppa(pankki, varasto, viitegen);
        
        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
