package statistics.kyselyrakentaja;

import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;
import statistics.matcher.composite.And;
import statistics.matcher.decorator.All;
import statistics.matcher.decorator.HasAtLeast;
import statistics.matcher.decorator.HasFewerThan;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this(new All());
    }

    public QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public Matcher build() {
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(matcher, new PlaysIn(team)));
    }

    public QueryBuilder hasAtleast(int value, String category) {
        return new QueryBuilder(new And(matcher, new HasAtLeast(value, category)));
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        return new QueryBuilder(new And(matcher, new HasFewerThan(value, category)));

    }
}
