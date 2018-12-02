package ohtu.intjoukkosovellus.service;

import ohtu.intjoukkosovellus.domain.IntSet;
import ohtu.intjoukkosovellus.util.CustomArrays;

// *** TODO ***
public class JoukkoOperaatiot {
    public static IntSet yhdiste(IntSet a, IntSet b) {
        IntSet x = new IntSet();

        int[] aTaulu = CustomArrays.resize(a.getSet(), a.getSize());
        int[] bTaulu = CustomArrays.resize(b.getSet(), b.getSize());

        for (int i = 0; i < aTaulu.length; i++) {
            x.add(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.add(bTaulu[i]);
        }
        return x;
    }

    public static IntSet leikkaus(IntSet a, IntSet b) {
        IntSet y = new IntSet();

        int[] aTaulu = CustomArrays.resize(a.getSet(), a.getSize());
        int[] bTaulu = CustomArrays.resize(b.getSet(), b.getSize());

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.add(bTaulu[j]);
                }
            }
        }
        return y;
    }

    public static IntSet erotus (IntSet a, IntSet b) {
        IntSet z = new IntSet();

        int[] aTaulu = CustomArrays.resize(a.getSet(), a.getSize());
        int[] bTaulu = CustomArrays.resize(b.getSet(), b.getSize());

        for (int i = 0; i < aTaulu.length; i++) {
            z.add(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.remove(i);
        }
        return z;
    }
}
