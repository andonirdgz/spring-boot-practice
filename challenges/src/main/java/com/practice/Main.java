package com.practice;

public class Main {
    static final int BOX_TARGET = 10;
    // A = [11, 10, 8, 12, 8, 10, 11] = +1
    // [10, 11, 8, 12, 8, 10, 11] = +1
    // [10, 10, 9, 12, 8, 10, 11] = -1
    // [10, 10, 10, 11, 8, 10, 11] = +1
    // [10, 10, 10, 10, 9, 10, 11] = -1
    // [10, 10, 10, 10, 10, 9, 11] = -1
    // [10, 10, 10, 10, 10, 10, 10]

    public static void main(String[] args) {
        int[] a = { 7, 15, 10, 8 };

        System.out.println(countMinMovements(a));

    }

    public static int countMinMovements(int[] a) {

        if (!hasAValidSolution(a))
            return -1;

        int moves = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int diff = a[i] - BOX_TARGET;

            a[i + 1] += diff;

            moves += diff < 0 ? -diff : diff;
        }

        return moves;
    }

    public static boolean hasAValidSolution(int[] a) {
        int sum = 0;

        for (int n : a) {
            sum += n;
        }

        return (sum == a.length * BOX_TARGET);
    }
}