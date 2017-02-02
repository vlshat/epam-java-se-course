package com.github.vlshat.hw1;

import java.util.Arrays;

/**
 * Created by wladislaw on 01.02.17.
 */
//max size 2 ^ 31 - 1
public class IntSet {

    private long[] data = new long[1];
    private long[] negativeData = new long[1];


    public IntSet(){

    }

    private IntSet(long[] data){
        this.data = data;
    }

    public boolean add(int value){


        if (value < 0){

            boolean isMinValue = false;
            if (value == Integer.MIN_VALUE){
                isMinValue = true;
            }
            int cell = -(value / 64);

            //isEnough
            if (cell >= negativeData.length){
                long[] newData = new long[cell + 1];
                System.arraycopy(negativeData, 0, newData,0,negativeData.length);
                negativeData = newData;
            }

            if (isMinValue){
                negativeData[cell] |= 1L;

            } else {
                negativeData[cell] |= 1L << (-value % 64);

            }


            return true;

        } else {
            int cell = (value / 64);

            if (cell >= data.length){
                long[] newData = new long[cell + 1];
                System.arraycopy(data, 0, newData,0,data.length);
                data = newData;
            }

            data[cell] |= 1L << (value % 64);

            return true;
        }

    }

    public boolean remove(int value){

        int cell = value / 64;
        if (cell >= data.length){
            return false;
        }
        data[cell] ^= (1L << (value % 64));

        return true;
    }

    public boolean contains(int value){

        if (value < 0){

            int cell = -(value / 64);

            if (cell >= negativeData.length){

                return false;

            } else if ((negativeData[cell] & (1L << (-value % 64))) == (1L << (-value % 64))){

                return true;

            } else{

                return false;
            }
        } else {
            int cell = value / 64;

            if (cell >= data.length){

                return false;

            } else if ((data[cell] & (1L << (value % 64))) == (1L << (value % 64))){

                return true;

            } else{

                return false;
            }

        }


    }

    public IntSet union(IntSet set){

        if (data.length >= set.data.length){

            long[] result = new long[data.length];
            System.arraycopy(data, 0, result, 0, data.length);

            for (int i = 0; i < set.data.length; i++) {
                result[i] |= set.data[i];
            }

            return new IntSet(result);

        } else {

            long[] result = new long[set.data.length];
            System.arraycopy(set.data, 0, result, 0, set.data.length);

            for (int i = 0; i < data.length; i++) {
                result[i] |= data[i];
            }

            return new IntSet(result);
        }

    }

    public IntSet intersection(IntSet set){

        if (data.length <= set.data.length){

            long[] result = new long[data.length];
            System.arraycopy(data, 0, result, 0, data.length);

            for (int i = 0; i < data.length; i++) {
                result[i] &= set.data[i];
            }

            return new IntSet(result);

        } else {

            long[] result = new long[set.data.length];
            System.arraycopy(set.data, 0, result, 0, set.data.length);

            for (int i = 0; i < set.data.length; i++) {
                result[i] &= data[i];
            }

            return new IntSet(result);
        }

    }

    public IntSet difference(IntSet set){

        if (data.length <= set.data.length){

            long[] result = new long[data.length];
            System.arraycopy(data, 0, result, 0, data.length);

            for (int i = 0; i < data.length; i++) {
                result[i] ^= set.data[i];
                result[i] &= data[i];

            }

            return new IntSet(result);

        } else {

            long[] result = new long[set.data.length];
            System.arraycopy(set.data, 0, result, 0, set.data.length);

            for (int i = 0; i < set.data.length; i++) {
                result[i] ^= set.data[i];
                result[i] &= set.data[i];
            }

            return new IntSet(result);
        }

    }

    public boolean isSubsetOf(IntSet set){

        if (data.length <= set.data.length){

            long[] result = new long[data.length];
            System.arraycopy(data, 0, result, 0, data.length);

            for (int i = 0; i < data.length; i++) {
                result[i] &= set.data[i];
            }

            if (Arrays.equals(data, result)){
                return true;
            } else {
                return false;
            }

        } else {

            long[] result = new long[set.data.length];
            System.arraycopy(set.data, 0, result, 0, set.data.length);

            for (int i = 0; i < set.data.length; i++) {
                result[i] &= data[i];
            }

            if (Arrays.equals(set.data, result)){
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean equals(Object object){

        if (this == object)
            return true;

        if (object == null)
            return false;

        if (this.getClass() != object.getClass())
            return false;

        IntSet intSet = (IntSet) object;

        if (!Arrays.equals(data, intSet.data))
            return false;

        return true;
    }

    private void checkCapacity(int cell, long[] data){

    }

}
