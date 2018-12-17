package ohtu.kivipaperisakset.util;

public class MostPopularMove {

    public static String calculate(int numOfRocks, int numOfPapers, int numOfScissors) {
        Move mostPopularMove = Move.KIVI;
        int numberOfMoves = 0;

        if (numOfRocks > numberOfMoves) {
            mostPopularMove = Move.KIVI;
            numberOfMoves = numOfRocks;
        }
        if (numOfPapers > numberOfMoves) {
            mostPopularMove = Move.PAPERI;
            numberOfMoves = numOfPapers;
        }
        if (numOfScissors > numberOfMoves) {
            mostPopularMove = Move.SAKSET;
            numberOfMoves = numOfScissors;
        }

        switch (mostPopularMove) {
            case KIVI: return "k";
            case PAPERI: return "p";
            default: return "s";
        }
    }
}
