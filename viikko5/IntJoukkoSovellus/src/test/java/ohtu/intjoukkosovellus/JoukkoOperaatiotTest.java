
package ohtu.intjoukkosovellus;

import java.util.Arrays;

import ohtu.intjoukkosovellus.domain.IntSet;
import ohtu.intjoukkosovellus.service.JoukkoOperaatiot;
import ohtu.intjoukkosovellus.util.ArrayUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    
    @Test
    public void testSomething() {
        IntSet eka = teeJoukko(1,2);
        IntSet toka = teeJoukko(3,4);
        
        IntSet tulos = JoukkoOperaatiot.yhdiste(eka, toka);
        int[] vastauksenLuvut = ArrayUtil.resize(tulos.getSet(), tulos.getSize());
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 

    private IntSet teeJoukko(int... luvut) {
        IntSet joukko = new IntSet();
        
        for (int luku : luvut) {
            joukko.add(luku);
        }
        
        return joukko;
    }
}
