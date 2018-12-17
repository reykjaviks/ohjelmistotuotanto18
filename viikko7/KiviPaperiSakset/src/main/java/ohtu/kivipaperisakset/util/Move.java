package ohtu.kivipaperisakset.util;

public class Move {
    private Moves move;
    private int numOfTimesUsed;

    public Move(Moves move) {
        this();
        this.move = move;
    }

    public Move() {
        numOfTimesUsed = 0;
    }

    public int getNumOfTimesUsed() {
        return numOfTimesUsed;
    }

    public void setMove(Moves move) {
        this.move = move;
    }

    public void setNumOfTimesUsed(int amount) {
        numOfTimesUsed = amount;
    }

    public Moves getMove() {
        return move;
    }
}
