
package ohtu.intjoukkosovellus;

import org.junit.Before;

public class IntJoukkoKaksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    public void setUp() {
        joukko = new IntJoukko(4, 2);
        joukko.add(10);
        joukko.add(3);
    }
}
