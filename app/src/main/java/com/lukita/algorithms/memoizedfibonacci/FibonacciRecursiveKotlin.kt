package com.lukita.algorithms.memoizedfibonacci

//Using Memoization caching for a faster algorithm
class FibonacciRecursiveKotlin {

    private var fibonacciCache = mutableListOf<Long>()

    fun findFibonacci(number: Int): Long {
        if (number <= 1) return number.toLong()

        if (fibonacciCache[number] != 0L) return fibonacciCache[number]

        val nthFibonacciNumber = findFibonacci(number - 1) + findFibonacci(number - 2)
        fibonacciCache[number] = nthFibonacciNumber

        return nthFibonacciNumber
    }
}