package laskin.strategy;

public abstract class Operaatio {
    protected int luku1;
    protected int luku2;

    public Operaatio(int luku1, int luku2) {
        this.luku1 = luku1;
        this.luku2 = luku2;
    }

    public static Operaatio luo(String operaatio, int luku1, int luku2) {
        if (operaatio.equals("plus")) {
            return new Plus(luku1, luku2);
        } else {
            return new Miinus(luku1, luku2);
        }
    }

    public abstract int laske();
}

