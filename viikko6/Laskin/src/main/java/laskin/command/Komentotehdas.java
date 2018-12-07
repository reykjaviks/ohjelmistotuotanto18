package laskin.command;
import java.util.HashMap;

public class Komentotehdas {
    private HashMap<String, Komento> komennot;

    public Komentotehdas() {
        komennot = new HashMap<>();
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("tuntematon");
        }
        return komento;
    }
}
