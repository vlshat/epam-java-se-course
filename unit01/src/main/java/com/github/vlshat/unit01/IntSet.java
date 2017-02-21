package com.github.vlshat.unit01;

import java.util.Arrays;

/**
 * Created by wladislaw on 01.02.17.
 *IntSet - data structure that stores values in range from -2^31 to 2^31 - 1.
 */
public class IntSet {

    private long[] positiveData;
    private long[] negativeData;


    public IntSet() {
        positiveData = new long[1];
        negativeData = new long[1];
    }

    private IntSet(long[] positiveData, long[] negativeData) {
        this.positiveData = positiveData;
        this.negativeData = negativeData;
    }

    /**
     * Adds value to set. Returns true on success
     * and false if the value is already in the set.
     * @param value
     * @return
     */
    public boolean add(int value) {

        if (contains(value)){
            return false;
        }

        if (value < 0) {
            addToArray(-(value / 64), -(value % 64), negativeData);
        } else {
            addToArray(value / 64, value % 64, positiveData);
        }

        return true;
    }

    /**
     * Flips bit in a specific array.
     * @param cell
     * @param shift
     * @param array
     */
    private void addToArray(int cell, int shift ,long[] array){

        if (cell >= array.length){
            array = expand(cell, array);
        }

        array[cell] |= 1L << shift;
    }

    /**
     * Expands inner array of the set.
     * @param capacity - new array have to have this capacity
     * @param array - source array
     * @return new array
     */
    private long[] expand(int capacity, long[] array) {

        long[] newData = new long[capacity + 1];
        System.arraycopy(array, 0, newData, 0, array.length);
        if (array == negativeData){
            negativeData = newData;
        } else {
            positiveData = newData;
        }

        return newData;
    }

    /**
     * Removes value. Return true on success, false if set doesn't contain value.
     * @param value
     * @return
     */
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
     * Checks existence of the value int the set.
     * @param value
     * @return
     */
    public boolean contains(int value) {

        if (value < 0) {
            return arrayContainsValue(negativeData, -(value / 64), -(value % 64));
        } else {
            return arrayContainsValue(positiveData, value / 64, value % 64);
        }
    }

    /**
     * Operation A | B
     * @param set
     * @return
     */
    public IntSet union(IntSet set) {

        return new IntSet(arraysDisjunction(positiveData, set.positiveData),
                arraysDisjunction(negativeData, set.negativeData));
    }


    /**
     * Operation A & B
     * @param set
     * @return
     */
    public IntSet intersection(IntSet set) {

        return new IntSet(arraysConjunction(positiveData, set.positiveData),
                arraysConjunction(negativeData, set.negativeData));
    }

    /**
     * Operation A \ B
     * @param set
     * @return
     */
    public IntSet difference(IntSet set) {

        return new IntSet(arraysDifference(positiveData, set.positiveData),
                arraysDifference(negativeData, set.negativeData));
    }


    /**
     *
     * @param set
     * @return
     */
    public boolean isSubsetOf(IntSet set) {

        if (set.positiveData.length < positiveData.length ||
                set.negativeData.length < negativeData.length){
            return false;
        }

        return Arrays.equals(positiveData, arraysConjunction(positiveData, set.positiveData))
                && Arrays.equals(negativeData, arraysConjunction(negativeData, set.negativeData));
    }

    /**
     * @param array - inner array
     * @param cell - cell of the value's range
     * @param shift - bit's location
     * @return
     */
    private boolean arrayContainsValue(long[] array, int cell, int shift) {

        if (cell >= array.length) {
            return false;
        } else if ((array[cell] & (1L << shift)) == (1L << shift)) {
            return true;
        }
        return false;
    }

    /**
     * Expects inner arrays of sets.
     * Executes operation A | B
     * @param firstArray
     * @param secondArray
     * @return
     */
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

    /**
     * Expects inner arrays of sets.
     * Executes operation A & B
     * @param firstArray
     * @param secondArray
     * @return
     */
    private long[] arraysConjunction(long[] firstArray, long[] secondArray) {

        int minLength = Math.min(firstArray.length, secondArray.length);
        long[] result = new long[minLength];

        System.arraycopy(firstArray, 0, result, 0, minLength);
        for (int i = 0; i < minLength; i++) {
            result[i] &= secondArray[i];
        }

        return result;
    }

    /**
     * Expects inner arrays of sets.
     * Executes operation A \ B
     * @param baseArray
     * @param secondArray
     * @return
     */
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

    /**
     * @param array - inner array
     * @param cell -cell of the value's range
     * @param shift - location of the bit
     * @return
     */
    private boolean removeBit(long[] array, int cell, int shift){

        if (cell >= array.length) {
            return false;
        }

        array[cell] &= ~(1L << shift);

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
