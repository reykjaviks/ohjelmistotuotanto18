package ohtu.kivipaperisakset.util;

public class MostPopularMove {

    public static String calculate(int numOfRocks, int numOfPapers, int numOfScissors) {
        Move mostPopularMove = new Move();

        if (numOfRocks > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMove(Moves.KIVI);
            mostPopularMove.setNumOfTimesUsed(numOfRocks);
        }
        if (numOfPapers > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMove(Moves.PAPERI);
            mostPopularMove.setNumOfTimesUsed(numOfPapers);
        }
        if (numOfScissors > mostPopularMove.getNumOfTimesUsed()) {
            mostPopularMove.setMove(Moves.SAKSET);
            mostPopularMove.setNumOfTimesUsed(numOfScissors);
        }

        switch (mostPopularMove.getMove()) {
            case KIVI: return "k";
            case PAPERI: return "p";
            default: return "s";
        }
    }
}
