package ohtu.intjoukkosovellus.util;

import ohtu.intjoukkosovellus.domain.IntSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArraysTest {

    private IntSet A;

    @Before
    public void setUp() {
        A = new IntSet();
        A.add(1);
        A.add(2);
        A.add(3);
    }

    @Test
    public void findValue() {
        assertEquals(0, CustomArrays.findValue(1, A.getSet()));
        assertEquals(1, CustomArrays.findValue(2, A.getSet()));
        assertEquals(2, CustomArrays.findValue(3, A.getSet()));
        assertEquals(-1, CustomArrays.findValue(4, A.getSet()));
    }

    @Test
    public void resize() {
    }

    @Test
    public void contains() {
    }
}