package ohtu.intjoukkosovellus.domain;

import ohtu.intjoukkosovellus.util.ArrayUtil;

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
        this.values = new int[capacity];
        this.increase = increase;
        numOfElements = 0;
    }

    public int[] getSet() {
        return values;
    }

    public int getSize() { return numOfElements; }

    private boolean setIsFull() {
        return numOfElements % values.length == 0;
    }

    private boolean setContains(int value) {
        return ArrayUtil.contains(value, this.values);
    }

    private boolean increaseSet() {
        values = ArrayUtil.resize(values, numOfElements + increase);
        return true;
    }

    private boolean insert(int value) {
        if (setIsFull()) { increaseSet(); }
        values[numOfElements] = value;
        numOfElements++;
        return true;
    }

    public boolean add(int value) {
        if (!setContains(value)) {
            return insert(value);
        }
        return false;
    }

    public boolean remove(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < numOfElements; i++) {
            if (luku == values[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                values[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < numOfElements - 1; j++) {
                apu = values[j];
                values[j] = values[j + 1];
                values[j + 1] = apu;
            }
            numOfElements--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (numOfElements == 0) {
            return "{}";
        } else if (numOfElements == 1) {
            return "{" + values[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < numOfElements - 1; i++) {
                tuotos += values[i];
                tuotos += ", ";
            }
            tuotos += values[numOfElements - 1];
            tuotos += "}";
            return tuotos;
        }
    }

}