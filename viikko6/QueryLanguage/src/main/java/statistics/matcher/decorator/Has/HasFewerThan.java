package statistics.matcher.decorator.Has;

import statistics.Player;

import java.lang.reflect.Method;

public class HasFewerThan extends Has {
    private int value;
    private String fieldName;

    public HasFewerThan(int value, String category) {
        this.value = value;
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue < value;
        } catch(Exception e) {
            System.out.println(e);
            throw new IllegalStateException("");
        }

    }
}
