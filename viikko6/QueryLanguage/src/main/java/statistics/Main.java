package statistics;

import statistics.matcher.*;
import statistics.kyselyrakentaja.QueryBuilder;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                         .hasAtleast(10, "goals")
                         .hasFewerThan(25, "goals")
                         .build();

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
