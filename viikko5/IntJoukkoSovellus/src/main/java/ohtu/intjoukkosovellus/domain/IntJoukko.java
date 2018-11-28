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

    public int[] getValues() {
        return this.values;
    }

    public int getAlkioidenLkm() {
        return this.alkioidenLkm;
    }

    private boolean valuesAreEmpty() {
        return this.alkioidenLkm == 0;
    }

    private boolean valuesAreFull() {
        return this.alkioidenLkm % this.values.length == 0;
    }

    private boolean insert(int value, int index) {
        this.values[index] = value;
        this.alkioidenLkm++;
        return true;
    }

    public boolean add(int value) {
        int beginning = 0;
        if (valuesAreEmpty()) {
            return insert(value, beginning);
        }
        int end = alkioidenLkm;
        if (!ArrayUtil.contains(value, this.values)) {
            insert(value, end);
            if (valuesAreFull()) {
                this.values = ArrayUtil.resize(this.values, this.alkioidenLkm + this.kasvatuskoko);
            }
            return true;
        }
        return false;
    }

    public boolean remove(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == values[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                values[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = values[j];
                values[j] = values[j + 1];
                values[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + values[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += values[i];
                tuotos += ", ";
            }
            tuotos += values[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

}