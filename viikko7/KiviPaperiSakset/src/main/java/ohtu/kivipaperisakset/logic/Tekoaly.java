package ohtu.kivipaperisakset.logic;

public class Tekoaly implements AI {

    private int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    public String calculateNextMove() {
        siirto++;
        siirto = calculateNextMove(siirto);

        switch (siirto) {
            case 0: return "k";
            case 1: return "p";
            default: return "s";
        }
    }

    public void setMove(String ekanSiirto) {
    }

    private int calculateNextMove(int move) {
        return move % 3;
    }
}
