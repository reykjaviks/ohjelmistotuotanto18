package laskin.strategy;

public class Miinus extends Operaatio {
    public Miinus(int luku1, int luku2) {
        super(luku1, luku2);
    }

    @Override
    public int laske() {
        return luku1 - luku2;
    }
}
