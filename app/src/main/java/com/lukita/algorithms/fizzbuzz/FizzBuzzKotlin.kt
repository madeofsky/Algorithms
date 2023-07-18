package com.lukita.algorithms.fizzbuzz

//O(n) Algorithm
class FizzBuzzKotlin {

    fun printFizzBuzz(numbersListSize: Int) {
        val fizzBuzzList = mutableListOf<String>()

        for (number in 0..numbersListSize) {
            when {
                isFizzBuzz(number) -> fizzBuzzList.add(FIZZBUZZ)
                isFizz(number) -> fizzBuzzList.add(FIZZ)
                isBuzz(number) -> fizzBuzzList.add(BUZZ)
                else -> fizzBuzzList.add(number.toString())
            }
        }

        printFizzBuzzList(fizzBuzzList)
    }

    private fun isFizz(number: Int): Boolean = number % 3 == 0

    private fun isBuzz(number: Int): Boolean = number % 5 == 0

    private fun isFizzBuzz(number: Int): Boolean = isFizz(number) && isBuzz(number)

    private fun printFizzBuzzList(fizzBuzzList: List<String>) {
        fizzBuzzList.forEach {
            println(it)
        }
    }

    companion object {
        const val FIZZ = "Fizz"
        const val BUZZ = "Buzz"
        const val FIZZBUZZ = "Fizz Buzz"
    }
}