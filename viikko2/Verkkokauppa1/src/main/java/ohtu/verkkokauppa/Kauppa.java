package ohtu.verkkokauppa;

import ohtu.rajapinnat.Pankki;
import ohtu.rajapinnat.Varasto;
import ohtu.rajapinnat.Viitegeneraattori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {
    private Ostoskori ostoskori;
    private String kaupanTili;
    private Pankki pankki;
    private Varasto varasto;
    private Viitegeneraattori viitegeneraattori;

    @Autowired
    public Kauppa(Pankki p, Varasto v, Viitegeneraattori vg) {
        this.pankki = p;
        this.varasto = v;
        this.viitegeneraattori = vg;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
