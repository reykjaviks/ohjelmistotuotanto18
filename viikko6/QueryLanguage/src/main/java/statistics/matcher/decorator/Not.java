package statistics.matcher.decorator;

import statistics.Player;
import statistics.matcher.Matcher;

public class Not implements Matcher {
    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        if (matcher.matches(p)) {
                return false;
        }
        return true;
    }

}
