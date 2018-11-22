package ohtu.verkkokauppa;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class KauppaTest {

    Varasto varasto;
    Pankki pankki;
    Viitegeneraattori viitegeneraattori;
    Kauppa kauppa;
    Ostoskori ostoskori;
    final String nimi = "pekka";
    final String tilinumero = "12345";

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        ostoskori = mock(Ostoskori.class);
        kauppa = new Kauppa(varasto, pankki, viitegeneraattori);

    }

    @Test
    // aloitetaan asiointi, koriin lisätään tuote jota on varastossa tarpeeksi ja tuote joka on loppu ja suoritetaan
    // ostos, varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
    public void tilisiirtoaKutsutaanOikeallaNimellaTilinumerollaJaSummallaKunTuotettaOnVarastossa() {
        when(varasto.saldo(1)).thenReturn(1);
        when(varasto.saldo(2)).thenReturn(0);

        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Koff Portteri", 3));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Fink Bräu I", 1));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu(nimi, tilinumero);

        verify(pankki).tilisiirto(eq(nimi), anyInt(), eq(tilinumero), anyString(), eq(3));

    }

    @Test
    //aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta jota on varastossa tarpeeksi ja suoritetaan ostos,
    //varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
    public void tilisiirtoaKutsutaanOikeallaNimellaTilinumerollaJaSummallaKunTuotteetOvatSamat() {
        when(varasto.saldo(1)).thenReturn(2);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Koff Portteri", 3));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu(nimi, tilinumero);

        verify(pankki).tilisiirto(eq(nimi), anyInt(), eq(tilinumero), anyString(), eq(6));
    }

    @Test
    public void tilisiirtoaKutsutaanOikeallaNimellaTilinumerollaJaSummalla() {
        when(varasto.saldo(1)).thenReturn(1);
        when(varasto.saldo(2)).thenReturn(1);

        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "Koff Portteri", 3));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Fink Bräu I", 1));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu(nimi, tilinumero);

        verify(pankki).tilisiirto(eq(nimi), anyInt(), eq(tilinumero), anyString(), eq(4));
    }

    @Test
    public void tilisiirtoaKutsutaanOikeallaNimellaJaTilinumerolla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu(nimi, tilinumero);
        verify(pankki).tilisiirto(eq(nimi), anyInt(), eq(tilinumero), anyString(), anyInt());
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

}