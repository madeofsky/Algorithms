package com.lukita.algorithms.fizzbuzz;

//O(n) Algorithm
public class FizzBuzzJava {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "Fizz Buzz";

    public void printFizzBuzz(Integer numbersListSize) {
        String[] fizzBuzzList = new String[numbersListSize + 1];

        for (int i = 0; i <= numbersListSize; i++) {
            if (isFizz(i)) {
                fizzBuzzList[i] = FIZZ;
            } else if (isBuzz(i)) {
                fizzBuzzList[i] = BUZZ;
            } else if (isFizzBuzz(i)) {
                fizzBuzzList[i] = FIZZBUZZ;
            } else {
                fizzBuzzList[i] = Integer.toString(i);
            }
        }

        printFizzBuzzList(fizzBuzzList);
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    private void printFizzBuzzList(String[] fizzBuzzList) {
        for (int i = 0; i <= fizzBuzzList.length; i++) {
            System.out.println(fizzBuzzList[i]);
        }
    }
}
