package ohtu;

import java.util.stream.*;
import java.util.Arrays;

public class Submission {

    private int week;
    private int hours;
    private int[] exercises;
    private String course;
    private int exerciseSum;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setHours(int hours) {
      this.hours = hours;
    }

    public int getHours() {
      return this.hours;
    }

    public int countExercises() {
        return IntStream.of(this.exercises).sum();
    }

    public void setExercises(int[] exercises) {
      this.exercises = exercises;
    }

    public int[] getExercises() {
      return this.exercises;
    }

    public void setCourse(String course) {
      this.course = course;
    }

    public String getCourse() {
      return this.course;
    }

    @Override
    public String toString() {
        return "" + this.course + ", viikko " + this.week +
                " tehtyjä tehtäviä yhteensä " + this.countExercises() +
                " aikaa kului " + this.hours + " tehdyt tehtävät " +
                Arrays.toString(this.exercises);
    }

}
