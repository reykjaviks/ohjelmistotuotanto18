package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5; // luotava uusi taulukko on
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        this.luvut = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
        this.alkioidenLkm = 0;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti >= 0) {
            this.luvut = new int[kapasiteetti];
            this.kasvatuskoko = OLETUSKASVATUS;
            this.alkioidenLkm = 0;
        }
        return;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin ja kasvatuskoon on oltava positiivisa kokonaislukuja.");
        }
        this.luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
        this.alkioidenLkm = 0;
    }

    public boolean lisaa(int luku) {
        int beginning = 0;
        if (luvutIsEmpty()) {
            addLuku(luku, beginning);
            return true;
        }
        
        if (!kuuluu(luku)) {
            if (luvutIsFull()) {
                this.luvut = resize(this.luvut, alkioidenLkm + kasvatuskoko);
            }
            addLuku(luku, alkioidenLkm);
            return true;
        }
        return false;
    }

    private void addLuku(int luku, int index) {
        this.luvut[index] = luku;
        this.alkioidenLkm++;
    }

    private boolean luvutIsEmpty() {
        return this.alkioidenLkm == 0 ? true : false;
    }

    private boolean luvutIsFull() {
        return this.alkioidenLkm % luvut.length == 0 ? true : false;
    }

    private int[] resize(int[] arr, int newSize) {
        return Arrays.copyOf(arr, newSize);
    }

    public boolean kuuluu(int luku) {
        return IntStream.of(this.luvut).anyMatch(x -> x == luku);
    }

    private int findLuku(int luku) {
        return Arrays.asList(this.luvut).indexOf(luku);
    }

    private void removeFromLuvut(int luku) {
        int position = findLuku(luku);
        System.out.println("POSITION: " + position);


        int[] a = Arrays.copyOfRange(this.luvut, 0, position);
        int[] b = Arrays.copyOfRange(this.luvut, position + 1, alkioidenLkm);
        this.luvut = concatArrays(a, b);

        alkioidenLkm--;
    }

    private int[] concatArrays(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

    public boolean poista(int luku) {
        if (kuuluu(luku)) {
            removeFromLuvut(luku);
            return true;
        }
        return false;

        /*
        int kohta = -1;
        int apu;

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                luvut[kohta] = 0;
                break;
            }
        }

        if (kohta != -1) {
            // replacee kaikki alkioit 
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = luvut[j]; //
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
        */
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvut[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += luvut[i];
                tuotos += ", ";
            }
            tuotos += luvut[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
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
                    y.lisaa(bTaulu[j]);
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
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
 
        return z;
    }
        
}