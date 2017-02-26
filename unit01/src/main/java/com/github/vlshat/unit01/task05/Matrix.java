package com.github.vlshat.unit01.task05;

import java.util.Arrays;

/**
 * Created by wladislaw on 26.02.17.
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[5][];
        int pointer = 0;

        for (int i = 0; i < matrix.length; i++){
            int[] matrixString = new int[5];
            if (i < matrix.length / 2){
                matrixString[pointer] = 1;
                matrixString[matrixString.length - 1 - pointer] = 1;
                pointer += 1;
                System.out.println(Arrays.toString(matrixString));
            } else if (i == matrix.length / 2){
                matrixString[pointer] = 1;
                pointer -= 1;
                System.out.println(Arrays.toString(matrixString));
            } else {
                matrixString[pointer] = 1;
                matrixString[matrixString.length - pointer - 1] = 1;
                System.out.println(Arrays.toString(matrixString));
                pointer -= 1;
            }
            matrix[i] = matrixString;
        }

    }
}
