package ohtu.kivipaperisakset.util;

public class MostPopularMove {

    public static Move calculate(int numOfRocks, int numOfPapers, int numOfScissors) {
        Move mostPopularMove = new Move();

        if (numOfRocks > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMoveName(Moves.KIVI);
            mostPopularMove.setNumOfTimesUsed(numOfRocks);
        }
        if (numOfPapers > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMoveName(Moves.PAPERI);
            mostPopularMove.setNumOfTimesUsed(numOfPapers);
        }
        if (numOfScissors > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMoveName(Moves.SAKSET);
            mostPopularMove.setNumOfTimesUsed(numOfScissors);
        }
        return mostPopularMove;
    }
}
