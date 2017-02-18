package com.github.vlshat.unit01;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by wladislaw on 04.02.17.
 */
public class Sequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double eps = scanner.nextDouble();

        for (int i = 1; ;i++) {
            if ((1 / Math.pow(i + 1, 2)) < eps){
                System.out.println(i);
                break;
            }
        }
    }
}
