package ohtu.verkkokauppa;

import ohtu.rajapinnat.Viitegeneraattori;
import org.springframework.stereotype.Component;

@Component
public class ViitegeneraattoriImpl implements Viitegeneraattori {
    private int seuraava;
    
    public ViitegeneraattoriImpl(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
