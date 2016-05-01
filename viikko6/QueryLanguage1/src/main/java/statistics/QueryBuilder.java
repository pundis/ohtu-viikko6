package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    Matcher m;

    public QueryBuilder() {
        this.m = new Matcher() {
            @Override
            public boolean matches(Player p) {
                return true;
            }
        };
    }

    public Matcher build(){
        Matcher m1 = m;
        this.m = new HasAtLeast(0, "goals");
        return m1;
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(this.m, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(this.m, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new Or(matchers);
        return this;
    }
    
    public QueryBuilder allOf(Matcher... matchers) {
        this.m = new And(matchers);
        return this;
    }
    
    public QueryBuilder noneOf(Matcher... matchers) {
        this.m = new Not(matchers);
        return this;
    }
    
}
