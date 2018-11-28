package ohtu.intjoukkosovellus.service;

import ohtu.intjoukkosovellus.domain.IntJoukko;
import ohtu.intjoukkosovellus.util.ArrayUtil;

public class JoukkoOperaatiot {
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();

        int[] aTaulu = ArrayUtil.resize(a.getValues(), a.getAlkioidenLkm());
        int[] bTaulu = ArrayUtil.resize(b.getValues(), b.getAlkioidenLkm());

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

        int[] aTaulu = ArrayUtil.resize(a.getValues(), a.getAlkioidenLkm());
        int[] bTaulu = ArrayUtil.resize(b.getValues(), b.getAlkioidenLkm());

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.add(bTaulu[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();

        int[] aTaulu = ArrayUtil.resize(a.getValues(), a.getAlkioidenLkm());
        int[] bTaulu = ArrayUtil.resize(b.getValues(), b.getAlkioidenLkm());

        for (int i = 0; i < aTaulu.length; i++) {
            z.add(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.remove(i);
        }
        return z;
    }
}
