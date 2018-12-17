package ohtu.kivipaperisakset.logic;

import ohtu.kivipaperisakset.logic.AI;

public class Tekoaly implements AI {

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    public String annaSiirto() {
        siirto++;
        siirto = calculateNextMove(siirto);

        switch (siirto) {
            case 0: return "k";
            case 1: return "p";
            default: return "s";
        }
    }

    public void asetaSiirto(String ekanSiirto) {
    }

    private int calculateNextMove(int move) {
        return move % 3;
    }
}
