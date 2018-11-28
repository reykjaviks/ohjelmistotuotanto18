
package ohtu.intjoukkosovellus;

import java.util.Arrays;

import ohtu.intjoukkosovellus.domain.IntJoukko;
import ohtu.intjoukkosovellus.service.JoukkoOperaatiot;
import ohtu.intjoukkosovellus.util.ArrayUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    
    @Test
    public void testSomething() {
        IntJoukko eka = teeJoukko(1,2);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = JoukkoOperaatiot.yhdiste(eka, toka);
        int[] vastauksenLuvut = ArrayUtil.resize(tulos.getValues(), tulos.getAlkioidenLkm());
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 

    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.add(luku);
        }
        
        return joukko;
    }
}
