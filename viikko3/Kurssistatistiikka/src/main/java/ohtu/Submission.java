package ohtu;

import java.util.Arrays;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    @Override
    public String toString() {
        return "" + this.course + ", viikko " + this.week + ":\n" +
                " tehtyjä tehtäviä yhteensä " + this.exercises.length +
                " aikaa kului " + this.hours + " tehdyt tehtävät " +
                Arrays.toString(this.exercises);
    }

}
