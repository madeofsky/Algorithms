package com.lukita.algorithms.memoizedfibonacci;

//Using Memoization caching for a faster algorithm
public class FibonacciRecursiveJava {

    private static long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 40;
        fibonacciCache = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            System.out.print(findFibonacci(i) + " ");
        }
    }

    public static long findFibonacci(int number) {
        if (number <= 1) return number;

        if (fibonacciCache[number] != 0) return fibonacciCache[number];

        long nthFibonacciNumber = findFibonacci(number - 1) + findFibonacci(number - 2);
        fibonacciCache[number] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }
}
