package ohtu.rajapinnat;

import ohtu.verkkokauppa.Tuote;

/**
 *
 * @author ebberg
 */
public interface Varasto {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);
    
}
