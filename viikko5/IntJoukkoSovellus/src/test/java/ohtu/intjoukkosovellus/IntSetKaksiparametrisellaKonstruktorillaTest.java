
package ohtu.intjoukkosovellus;

import ohtu.intjoukkosovellus.domain.IntSet;
import org.junit.Before;

public class IntSetKaksiparametrisellaKonstruktorillaTest extends IntSetTest {
    
    @Before
    public void setUp() {
        joukko = new IntSet(4, 2);
        joukko.add(10);
        joukko.add(3);
    }
}
