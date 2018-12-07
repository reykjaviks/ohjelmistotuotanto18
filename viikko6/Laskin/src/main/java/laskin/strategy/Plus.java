package laskin.strategy;

public class Plus extends Operaatio {
    public Plus(int luku1, int luku2) {
        super(luku1, luku2);
    }

    @Override
    public int laske() {
        return luku1 + luku2;
    }
}