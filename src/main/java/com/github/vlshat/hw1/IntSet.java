package com.github.vlshat.hw1;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * Created by wladislaw on 01.02.17.
 */
public class IntSet {

    private long[] data = new long[1];
    private long[] negativeData = new long[1];


    public IntSet() {

    }

    private IntSet(long[] positiveData, long[] negativeData) {
        this.data = positiveData;
        this.negativeData = negativeData;
    }

    /**
     * @param value
     * @return
     */
    public boolean add(int value) {

        if (value < 0) {

            int cell = -(value / 64);

            //isEnough
            if (cell >= negativeData.length) {
                negativeData = expand(cell, negativeData);
            }

            negativeData[cell] |= 1L << (-value % 64);

            return true;

        } else {
            int cell = (value / 64);

            if (cell >= data.length) {
                data = expand(cell, data);
            }

            data[cell] |= 1L << (value % 64);

            return true;
        }
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

        if (value < 0) {
            int cell = -(value / 64);
            if (cell >= negativeData.length) {
                return false;
            } else if ((negativeData[cell] & (1L << -(value % 64))) != (1L << -(value % 64))){
                return false;
            }

            negativeData[cell] ^= (1L << -(value % 64));

            return true;

        } else {
            int cell = value / 64;

            if (cell >= data.length) {
                return false;
            } else if ((data[cell] & (1L << (value % 64))) != (1L << (value % 64))){
                return false;
            }
            data[cell] ^= (1L << (value % 64));

            return true;
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
            return arrayContainsValue(data, value / 64, value % 64);
        }
    }


    /**
     * @param set
     * @return
     */
    public IntSet union(IntSet set) {

        long[] negativeResult;
        long[] positiveResult;

        if (data.length >= set.data.length) {

            positiveResult = arraysDisjuction(data, set.data);

        } else {

            positiveResult = arraysDisjuction(set.data, data);
        }

        if (negativeData.length >= set.negativeData.length) {

            negativeResult = arraysDisjuction(negativeData, set.negativeData);
        } else {
            negativeResult = arraysDisjuction(set.negativeData, negativeData);
        }

        return new IntSet(positiveResult, negativeResult);
    }


    public IntSet intersection(IntSet set) {

        long[] positiveResult;
        long[] negativeResult;

        if (data.length <= set.data.length) {

            positiveResult = arraysConjunction(set.data, data);

        } else {

            positiveResult = arraysConjunction(data, set.data);
        }

        if (negativeData.length <= set.negativeData.length) {

            negativeResult = arraysConjunction(set.negativeData, negativeData);

        } else {

            negativeResult = arraysConjunction(negativeData, set.negativeData);
        }

        return new IntSet(positiveResult, negativeResult);

    }

    public IntSet difference(IntSet set) {

        long[] positiveResult;
        long[] negativeResult;

        positiveResult = arraysDifference(data, set.data);
        negativeResult = arraysDifference(negativeData, set.negativeData);

        return new IntSet(positiveResult, negativeResult);
    }


    public boolean isSubsetOf(IntSet set) {

        if (set.data.length < data.length ||
                set.negativeData.length < negativeData.length){
            return false;
        }

        long[] positiveResult;
        long[] negativeResult;

        if (data.length <= set.data.length) {

            positiveResult = arraysConjunction(set.data, data);

        } else {

            positiveResult = arraysConjunction(data, set.data);
        }

        if (negativeData.length <= set.negativeData.length) {

            negativeResult = arraysConjunction(set.negativeData, negativeData);

        } else {

            negativeResult = arraysConjunction(negativeData, set.negativeData);
        }

        if (Arrays.equals(data, positiveResult) && Arrays.equals(negativeData, negativeResult)){
            return true;
        }

        return false;

    }

    public boolean equals(Object object) {

        if (this == object)
            return true;

        if (object == null)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        IntSet intSet = (IntSet) object;

        if (!Arrays.equals(data, intSet.data))
            return false;

        if (!Arrays.equals(negativeData, intSet.negativeData))
            return false;

        return true;
    }

    private boolean arrayContainsValue(long[] array, int cell, int shift) {

        if (cell >= array.length) {

            return false;

        } else if ((array[cell] & (1L << shift)) == (1L << shift)) {

            return true;

        }

        return false;
    }

    private long[] arraysDisjuction(long[] bigArray, long[] smallArray) {

        long[] result = new long[bigArray.length];
        System.arraycopy(bigArray, 0, result, 0, bigArray.length);

        for (int i = 0; i < smallArray.length; i++) {
            result[i] |= smallArray[i];
        }

        return result;

    }

    private long[] arraysConjunction(long[] bigArray, long[] smallArray) {

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
}
