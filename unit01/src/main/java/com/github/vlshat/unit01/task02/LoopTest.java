package com.github.vlshat.unit01.task02;

import java.util.Scanner;

/**
 * Created by wladislaw on 04.02.17.
 */
public class LoopTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double h = scanner.nextDouble();

        for (double i = a; i <= b ; i+=h) {
            System.out.println(i + "\t" + (Math.tan(2 * i) - 3));
        }
    }
}
