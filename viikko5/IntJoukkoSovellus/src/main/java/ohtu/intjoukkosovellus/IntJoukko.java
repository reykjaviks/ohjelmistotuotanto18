package ohtu.intjoukkosovellus;

import ohtu.intjoukkosovellus.util.ArrayUtil;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] values;      // Joukon values säilytetään taulukon alkupäässä.
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla.

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

    private boolean insert(int value, int index) {
        this.values[index] = value;
        this.alkioidenLkm++;
        return true;
    }

    private boolean valuesAreEmpty() {
        return this.alkioidenLkm == 0;
    }

    private boolean valuesAreFull() {
        return this.alkioidenLkm % this.values.length == 0;
    }

    public boolean add(int value) {
        int beginning = 0;
        if (this.valuesAreEmpty()) {
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

    public boolean contains(int luku) {
        int on = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == values[i]) {
                on++;
            }
        }
        if (on > 0) {
            return true;
        } else {
            return false;
        }
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

    //

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = values[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.add(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.add(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.add(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.add(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.remove(i);
        }
 
        return z;
    }
        
}