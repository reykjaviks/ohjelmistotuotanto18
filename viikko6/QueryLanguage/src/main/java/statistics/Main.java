package statistics;

import statistics.matcher.*;

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

        for (Player player : stats.matches(or)) {
            System.out.println( player );
        }
    }
}
