package ohtu.kivipaperisakset;

public class Tekoaly {

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

    public int calculateNextMove(int move) {
        return move % 3;
    }

    void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
