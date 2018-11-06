package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    static final double vertailuTarkkuus = 0.0001;
    static final double alkuTilavuus = 10;
    static final double tyhjaTilavuus = 0;
    static final double tyhjaSaldo = 0;

    @Before
    public void setUp() {
        varasto = new Varasto(alkuTilavuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(tyhjaSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(alkuTilavuus, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoVarastonJonkaTilavuusOnNolla() {
        varasto = new Varasto(-1);
        assertEquals(tyhjaTilavuus, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoVarastonOikeallaTilavuudella() {
        varasto = new Varasto(100, 90);
        assertEquals(100, varasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(90, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktorinNegTilavuusParametriAsettaaVarastonTilavuudeksiNollan() {
        varasto = new Varasto(-1, 100);
        assertEquals(tyhjaTilavuus, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void negAlkusaldoAsettaaSaldoksiNollan() {
        varasto = new Varasto(100, -1);
        assertEquals(tyhjaSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void saldoOnSuuurempiKuinTilavuus() {
        varasto = new Varasto(10, 100);
        assertEquals(varasto.getSaldo(), varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuTilavuus() {
        double alkuTilavuus = 20;
        varasto = new Varasto(alkuTilavuus);
        assertEquals(alkuTilavuus, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldo() {
        assertEquals(tyhjaSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(-1);
        assertEquals(tyhjaSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonTilavuuttaSuurempiLisaysTayttaaVaraston() {
        varasto.lisaaVarastoon(100);
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negOttoEiMuutaSaldoa() {
        assertEquals(tyhjaSaldo, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }

    @Test
    public void varastonTyhjennys() {
        varasto.otaVarastosta(varasto.getSaldo() + 1000);
        assertEquals(tyhjaSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottoOttaaOikeanMaaran() {
        double otto = varasto.getSaldo() + 1000;
        assertEquals(varasto.getSaldo(), varasto.otaVarastosta(otto), vertailuTarkkuus);
    }

    @Test
    public void paljonkoMahtuuPalauttaaTilavuudenJaSaldonErotuksen() {
        assertEquals(varasto.getTilavuus() - varasto.getSaldo(), varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void toStringPalauttaaOikeanViestin() {
        String viesti =  "saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu();
        assertEquals(viesti, varasto.toString());
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(2);
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

}
