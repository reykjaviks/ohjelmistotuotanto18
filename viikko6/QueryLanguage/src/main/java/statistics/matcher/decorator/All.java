package statistics.matcher.decorator;

import statistics.Player;
import statistics.matcher.Matcher;

public class All implements Matcher{

    public All() {
    }

    @Override
    public boolean matches(Player p) {
        return true;
    }

}
