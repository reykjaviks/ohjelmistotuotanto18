package ohtu.intjoukkosovellus.util;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomArrays {
    public static int findValue(int value, int[] arr) { return Ints.indexOf(arr, value); }

    public static int[] resize(int[] arr, int newSize) {
        return Arrays.copyOf(arr, newSize);
    }

    public static boolean contains(int value, int[] arr) {
        return IntStream.of(arr).anyMatch(x -> x == value);
    }
}
