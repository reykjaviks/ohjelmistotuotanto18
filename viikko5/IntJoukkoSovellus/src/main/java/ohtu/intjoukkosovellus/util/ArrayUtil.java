package ohtu.intjoukkosovellus.util;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayUtil {
    public static int findValue(int value, int[] arr) {
        return Arrays.asList(arr).indexOf(value);
    }

    public static int[] resize(int[] arr, int newSize) {
        return Arrays.copyOf(arr, newSize);
    }

    public static boolean contains(int value, int[] arr) {
        return IntStream.of(arr).anyMatch(x -> x == value);
    }
}
