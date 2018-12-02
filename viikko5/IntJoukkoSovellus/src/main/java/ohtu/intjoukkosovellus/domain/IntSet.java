package ohtu.intjoukkosovellus.domain;

import ohtu.intjoukkosovellus.util.ArrayUtil;

public class IntJoukko {
    public final static int OLETUSKAPASITEETTI = 5;
    public final static int OLETUSKASVATUS = 5;
    private int[] values;
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int alkioidenLkm;

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen.");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen.");
        }
        this.values = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
        alkioidenLkm = 0;
    }

    public int[] getSet() {
        return this.values;
    }

    public int getSize() {
        return this.alkioidenLkm;
    }

    private boolean setIsEmpty() {
        return this.alkioidenLkm == 0;
    }

    private boolean setIsFull() {
        return this.alkioidenLkm % this.values.length == 0;
    }

    private boolean setContains(int value) {
        return ArrayUtil.contains(value, this.values);
    }

    private boolean increaseSetSize() {
        return true;

    }

    private boolean insert(int value, int index) {
        values[index] = value;
        alkioidenLkm++;
        return true;
    }

    public boolean add(int value) {
        int beginning = 0;
        if (setIsEmpty()) {
            return insert(value, beginning);
        }


        int end = alkioidenLkm;
        if (!setContains(value)) {
            insert(value, end);
            if (setIsFull()) {
                this.values = ArrayUtil.resize(this.values, this.alkioidenLkm + this.kasvatuskoko);
            }
            return true;
        }
        return false;
    }

    public boolean remove(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < numOfElements; i++) {
            if (luku == values[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                values[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < numOfElements - 1; j++) {
                apu = values[j];
                values[j] = values[j + 1];
                values[j + 1] = apu;
            }
            numOfElements--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (numOfElements == 0) {
            return "{}";
        } else if (numOfElements == 1) {
            return "{" + values[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < numOfElements - 1; i++) {
                tuotos += values[i];
                tuotos += ", ";
            }
            tuotos += values[numOfElements - 1];
            tuotos += "}";
            return tuotos;
        }
    }

}