package statistics;

import statistics.matcher.*;
import statistics.matcher.composite.And;
import statistics.matcher.composite.Or;
import statistics.matcher.decorator.All;
import statistics.matcher.decorator.Has.HasAtLeast;
import statistics.matcher.decorator.Has.HasFewerThan;
import statistics.matcher.decorator.Not;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));


        // Matcherit
        Matcher and = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );

        Matcher or = new Or( new HasAtLeast(40, "goals"),
                             new HasAtLeast(60, "assists"),
                             new HasAtLeast(85, "points")
        );

        Matcher not = new Not( new HasAtLeast(1, "goals") );

        Matcher fewerThan = new HasFewerThan(1, "goals");

        int count = 0;
        for (Player player : stats.matches(not)) {
            System.out.println( player );
            count++;
        }
    }
}
