package statistics.matcher.decorator;

import statistics.Player;
import statistics.matcher.Matcher;

public class All implements Matcher{
    private Matcher matcher;

    public All(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        if (!matcher.matches(p)) {
            return false;
        }
        return true;
    }
}
