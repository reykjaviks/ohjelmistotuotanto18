package statistics.matcher.decorator;

import statistics.Player;
import statistics.matcher.Matcher;

import java.lang.reflect.Method;

public class Has implements Matcher {
    private String fieldName;

    public Has() {
        this.fieldName = "";
    }

    public Has(String category) {
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue >= 0;
        } catch (Exception e) {

        }
        return false;
    }

}
