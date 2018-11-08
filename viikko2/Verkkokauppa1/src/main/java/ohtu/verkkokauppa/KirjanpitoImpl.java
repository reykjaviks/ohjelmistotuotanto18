package ohtu.verkkokauppa;

import ohtu.rajapinnat.Kirjanpito;
import java.util.ArrayList;

public class KirjanpitoImpl implements Kirjanpito {
    private ArrayList<String> tapahtumat;

    public KirjanpitoImpl() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
