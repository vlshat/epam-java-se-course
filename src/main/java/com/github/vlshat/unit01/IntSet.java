package com.github.vlshat.unit01;

import java.util.Arrays;

/**
 * Created by wladislaw on 01.02.17.
 */
public class IntSet {

    private long[] positiveData;
    private long[] negativeData;


    public IntSet() {
        positiveData = new long[1];
        negativeData = new long[1];
    }

    private IntSet(long[] positiveData, long[] negativeData) {
        this();
        this.positiveData = positiveData;
        this.negativeData = negativeData;
    }

    /**
     * @param value
     * @return
     */
    public boolean add(int value) {

        if (contains(value)){
            return false;
        }

        if (value < 0) {

            int cell = -(value / 64);
            //isEnough
            if (cell >= negativeData.length) {
                negativeData = expand(cell, negativeData);
            }
            negativeData[cell] |= 1L << -(value % 64);

        } else {
            int cell = (value / 64);
            if (cell >= positiveData.length) {
                positiveData = expand(cell, positiveData);
            }
            positiveData[cell] |= 1L << (value % 64);
        }
        return true;
    }

    /**
     * @param capacity - new array have to have this capacity
     * @param array - source array
     * @return new array
     */
    private long[] expand(int capacity, long[] array) {
        long[] newData = new long[capacity + 1];
        System.arraycopy(array, 0, newData, 0, array.length);
        return newData;
    }

    public boolean remove(int value) {

        if (!contains(value)){
            return false;
        }

        if (value < 0) {
            return removeBit(negativeData, -(value / 64), -(value % 64));
        } else {
            return removeBit(positiveData, value / 64, value % 64);
        }

    }

    /**
     * @param value - Does set contains this value?
     * @return
     */
    public boolean contains(int value) {

        if (value < 0) {
            return arrayContainsValue(negativeData, -(value / 64), -(value % 64));
        } else {
            int cell = value / 64;
            return arrayContainsValue(positiveData, value / 64, value % 64);
        }
    }

    /**
     * @param set
     * @return
     */
    public IntSet union(IntSet set) {

        return new IntSet(arraysDisjunction(positiveData, set.positiveData),
                arraysDisjunction(negativeData, set.negativeData));
    }


    public IntSet intersection(IntSet set) {

        return new IntSet(arraysConjunction(positiveData, set.positiveData),
                arraysConjunction(negativeData, set.negativeData));

    }

    public IntSet difference(IntSet set) {

        return new IntSet(arraysDifference(positiveData, set.positiveData),
                arraysDifference(negativeData, set.negativeData));
    }


    public boolean isSubsetOf(IntSet set) {

        if (set.positiveData.length < positiveData.length ||
                set.negativeData.length < negativeData.length){
            return false;
        }

        if (Arrays.equals(positiveData, arraysConjunction(positiveData, set.positiveData))
                && Arrays.equals(negativeData, arraysConjunction(negativeData, set.negativeData))){
            return true;
        }

        return false;

    }


    private boolean arrayContainsValue(long[] array, int cell, int shift) {

        if (cell >= array.length) {

            return false;

        } else if ((array[cell] & (1L << shift)) == (1L << shift)) {

            return true;

        }

        return false;
    }

    private long[] arraysDisjunction(long[] firstArray, long[] secondArray) {

        long[] bigArray;
        long[] smallArray;

        if (firstArray.length >= secondArray.length){
            bigArray = firstArray;
            smallArray = secondArray;
        } else {
            bigArray = firstArray;
            smallArray = secondArray;
        }

        long[] result = new long[bigArray.length];
        System.arraycopy(bigArray, 0, result, 0, bigArray.length);

        for (int i = 0; i < smallArray.length; i++) {
            result[i] |= smallArray[i];
        }

        return result;

    }

    private long[] arraysConjunction(long[] firstArray, long[] secondArray) {

        long[] bigArray;
        long[] smallArray;

        if (firstArray.length <= secondArray.length){
            smallArray = firstArray;
            bigArray = secondArray;
        } else {
            smallArray = secondArray;
            bigArray = firstArray;
        }

        long[] result = new long[smallArray.length];
        System.arraycopy(smallArray, 0, result, 0, smallArray.length);

        for (int i = 0; i < smallArray.length; i++) {
            result[i] &= bigArray[i];
        }

        return result;
    }

    private long[] arraysDifference(long[] baseArray, long[] secondArray) {

        int minLength = 0;

        if (baseArray.length <= secondArray.length){
            minLength = baseArray.length;
        } else {
            minLength = secondArray.length;
        }

        long[] result = new long[baseArray.length];
        System.arraycopy(baseArray, 0, result, 0, baseArray.length);

        for (int i = 0; i < minLength; i++) {
            result[i] ^= secondArray[i];
            result[i] &= baseArray[i];
        }

        return result;
    }

    private boolean removeBit(long[] array, int cell, int shift){

        if (cell >= array.length) {
            return false;
        }

        array[cell] ^= (1L << shift);

        return true;
    }

    public boolean equals(Object object) {

        if (this == object)
            return true;

        if (object == null)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        IntSet intSet = (IntSet) object;

        //not optimal
        return this.isSubsetOf(intSet) && intSet.isSubsetOf(this);
    }

}
