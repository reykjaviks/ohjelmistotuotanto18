package ohtu.rajapinnat;

import java.util.ArrayList;

/**
 *
 * @author ebberg
 */
public interface Kirjanpito {
    ArrayList<String> getTapahtumat();
    void lisaaTapahtuma(String tapahtuma);
}
