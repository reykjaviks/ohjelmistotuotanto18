package ohtu.intjoukkosovellus;

import ohtu.intjoukkosovellus.domain.IntSet;
import ohtu.intjoukkosovellus.util.CustomArrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntSetTest {

    IntSet joukko;

    @Before
    public void setUp() {
        joukko = new IntSet();
        joukko.add(10);
        joukko.add(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.add(4);
        assertEquals(3, joukko.getSize());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.add(10);
        joukko.add(3);
        assertEquals(2, joukko.getSize());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(CustomArrays.contains(10, joukko.getSet()));
        assertFalse(CustomArrays.contains(5, joukko.getSet()));
        assertTrue(CustomArrays.contains(3, joukko.getSet()));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.remove(3);
        assertFalse(CustomArrays.contains(3, joukko.getSet()));
        assertEquals(1, joukko.getSize());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.add(55);
        joukko.remove(10);
        joukko.add(99);

        int[] vastaus = CustomArrays.resize(joukko.getSet(), joukko.getSize());

        java.util.Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.add(luku);
        }
        assertEquals(14, joukko.getSize());
        assertTrue(CustomArrays.contains(11, joukko.getSet()));
        joukko.remove(11);
        assertFalse(CustomArrays.contains(11, joukko.getSet()));
        assertEquals(13, joukko.getSize());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntSet();
        joukko.add(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntSet();
        assertEquals("{}", joukko.toString());
    }     
}
