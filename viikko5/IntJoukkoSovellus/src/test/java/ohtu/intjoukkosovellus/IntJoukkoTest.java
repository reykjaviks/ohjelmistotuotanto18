package ohtu.intjoukkosovellus;

import java.util.Arrays;

import ohtu.intjoukkosovellus.domain.IntJoukko;
import ohtu.intjoukkosovellus.util.ArrayUtil;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.add(10);
        joukko.add(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.add(4);
        assertEquals(3, joukko.getAlkioidenLkm());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.add(10);
        joukko.add(3);
        assertEquals(2, joukko.getAlkioidenLkm());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(ArrayUtil.contains(10, joukko.getValues()));
        assertFalse(ArrayUtil.contains(5, joukko.getValues()));
        assertTrue(ArrayUtil.contains(3, joukko.getValues()));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.remove(3);
        assertFalse(ArrayUtil.contains(3, joukko.getValues()));
        assertEquals(1, joukko.getAlkioidenLkm());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.add(55);
        joukko.remove(10);
        joukko.add(99);

        int[] vastaus = ArrayUtil.resize(joukko.getValues(), joukko.getAlkioidenLkm());

        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.add(luku);
        }
        assertEquals(14, joukko.getAlkioidenLkm());
        assertTrue(ArrayUtil.contains(11, joukko.getValues()));
        joukko.remove(11);
        assertFalse(ArrayUtil.contains(11, joukko.getValues()));
        assertEquals(13, joukko.getAlkioidenLkm());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntJoukko();
        joukko.add(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }     
}
