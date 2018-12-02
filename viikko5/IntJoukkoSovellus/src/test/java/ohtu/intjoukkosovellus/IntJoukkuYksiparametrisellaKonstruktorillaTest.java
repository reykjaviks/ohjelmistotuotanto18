
package ohtu.intjoukkosovellus;

import ohtu.intjoukkosovellus.domain.IntSet;
import org.junit.Before;


public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntSetTest {
    
    @Before
    @Override
    public void setUp() {
        joukko = new IntSet(3);
        joukko.add(10);
        joukko.add(3);
    }
    
    // perii kaikki testit luokasta IntSetTest
}
