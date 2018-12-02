package ohtu.intjoukkosovellus.domain;

import ohtu.intjoukkosovellus.util.CustomArrays;

public class IntSet {
    public final static int CAPACITY = 5;
    public final static int INCREASE = 5;

    private int[] values;
    private int increase;
    private int numOfElements;

    public IntSet() {
        this(CAPACITY, INCREASE);
    }

    public IntSet(int capacity) {
        this(capacity, INCREASE);
    }

    public IntSet(int capacity, int increase) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen.");
        }
        if (increase < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen.");
        }
        values = new int[capacity];
        numOfElements = 0;
        this.increase = increase;
    }

    public int[] getSet() {
        return values;
    }

    public int getSize() { return numOfElements; }

    public boolean add(int value) {
        if (!setContains(value)) {
            return insert(value);
        }
        return false;
    }

    public boolean remove(int value) {
        int emptyValue = 0;
        int index;
        if (setContains(value)) {
            index = findIndex(value);
            values[index] = emptyValue;
            return moveElementsLeft(index);
        }
        return false;
    }

    @Override
    public String toString() {
        switch(numOfElements) {
            case 0: return "{}";
            case 1: return "{" + values[0] + "}";
            default: return stringBuilder();
        }
    }

    private boolean setIsFull() {
        return numOfElements % values.length == 0;
    }

    private boolean setContains(int value) {
        return CustomArrays.contains(value, this.values);
    }

    private boolean increaseSet() {
        values = CustomArrays.resize(values, numOfElements + increase);
        return true;
    }

    private int findIndex(int value) {
        return CustomArrays.findValue(value, values);
    }

    private boolean insert(int value) {
        if (setIsFull()) { increaseSet(); }
        values[numOfElements] = value;
        numOfElements++;
        return true;
    }

    private boolean moveElementsLeft(int startingIndex) {
        int help;
        for (int i = startingIndex; i < numOfElements - 1; i++) {
            help = values[startingIndex];
            values[i] = values[i + 1];
            values[i + 1] = help;
        }
        numOfElements--;
        return true;
    }

    private String stringBuilder() {
        String str = "{";
        for (int i = 0; i < numOfElements - 1; i++) {
            str += values[i] + ", ";
        }
        str += values[numOfElements - 1] + "}";
        return str;
    }

}