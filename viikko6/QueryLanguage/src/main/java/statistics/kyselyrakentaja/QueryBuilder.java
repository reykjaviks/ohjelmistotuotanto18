package statistics.kyselyrakentaja;

import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;
import statistics.matcher.composite.And;
import statistics.matcher.composite.Or;
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
        Matcher playsIn = new PlaysIn(team);
        return QueryBuilderLisatyllaEhdolla(playsIn);
    }

    public QueryBuilder hasAtleast(int value, String category) {
        Matcher hasAtleast = new HasAtLeast(value, category);
        return QueryBuilderLisatyllaEhdolla(hasAtleast);
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        Matcher hasFewerThan = new HasFewerThan(value, category);
        return QueryBuilderLisatyllaEhdolla(hasFewerThan);
    }

    public QueryBuilder oneOf(Matcher...matchers) {
        return new QueryBuilder(new Or(matchers));
    }

    private QueryBuilder QueryBuilderLisatyllaEhdolla(Matcher matcher) {
        return new QueryBuilder(new And(this.matcher, matcher));
    }
}
