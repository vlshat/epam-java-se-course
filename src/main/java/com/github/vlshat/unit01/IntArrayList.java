package com.github.vlshat.unit01;

/**
 * Created by wladislaw on 05.02.17.
 */
import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntArrayList {
    private int[] data;
    private int size;

    public IntArrayList(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getSize() {
        return size;
    }

    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }

    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length/2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sort(){

        //mergeSort(data, 0, getSize(), new int[getSize()]);
       risingMergeSort(data, 0, getSize(), new int[getSize()]);
    }


    /**
     * Expects collection to be sorted.
     *
     * @param value value to find in collection
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearch(int value) {
        throw new UnsupportedOperationException();
    }

    private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {

        int length = endExclusive - startInclusive;

        if (length <= 1){
            return;
        }

        int mid = startInclusive + length/2;

        mergeSort(data, startInclusive, mid, free);
        mergeSort(data, mid, endExclusive, free);

        merger(data, startInclusive, mid, endExclusive, free);
    }

    private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int pointerA = startInclusive;
        int pointerB = mid;

        for (int k = startInclusive; k < endExclusive; k++){
            if (pointerA >= mid){
                data[k] = free[pointerB++];
            } else if (pointerB >= endExclusive){
                data[k] = free[pointerA++];
            } else if (free[pointerA] < free[pointerB]){
                data[k] = free[pointerA++];
            } else {
                data[k] = free[pointerB++];
            }
        }
    }

    public static void risingMergeSort(int[] data, int startInclusive, int endExclusive, int[] free){
        int length = data.length;

        for (int size = 1; size < length; size+=size){
            for (int start = 0; start < length; start+= size + size){
                merger(data, start, start + size,Math.min(start + size + size, length), free);
            }
            System.out.println(Arrays.toString(data));
        }
    }

    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapasity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapasity);
    }

    private int getCapacity() {
        return data.length;
    }

    public int[] getData() {
        return data;
    }
}
