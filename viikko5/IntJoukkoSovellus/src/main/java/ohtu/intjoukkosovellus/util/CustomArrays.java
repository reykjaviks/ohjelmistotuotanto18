package ohtu.intjoukkosovellus.util;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomArrays {
    public static int findValue(int value, int[] arr) {
        return java.util.Arrays.asList(arr).indexOf(value);
    }

    public static int[] resize(int[] arr, int newSize) {
        return java.util.Arrays.copyOf(arr, newSize);
    }

    public static boolean contains(int value, int[] arr) {
        return IntStream.of(arr).anyMatch(x -> x == value);
    }
}
