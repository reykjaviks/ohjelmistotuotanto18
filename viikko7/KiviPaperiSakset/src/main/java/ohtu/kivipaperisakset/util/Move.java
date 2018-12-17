package ohtu.kivipaperisakset.util;

public class Move {
    private Moves moveName;
    private int numOfTimesUsed;

    public Move(Moves moveName) {
        this();
        this.moveName = moveName;
    }

    public Move() {
        numOfTimesUsed = 0;
    }

    public int getNumOfTimesUsed() {
        return numOfTimesUsed;
    }

    public void setMoveName(Moves moveName) {
        this.moveName = moveName;
    }

    public void setNumOfTimesUsed(int amount) {
        numOfTimesUsed = amount;
    }

    public Moves getMoveName() {
        return moveName;
    }
}
