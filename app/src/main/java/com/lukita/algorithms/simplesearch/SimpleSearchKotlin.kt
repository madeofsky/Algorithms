package com.lukita.algorithms.simplesearch

// O(n) Algorithm
class SimpleSearchKotlin {

    fun findValue(sortedList: List<Int>, targetValue: Int): Map<Int, Int>? {
        var searchCount = 0

        for (element in sortedList) {
            searchCount++

            if (element == targetValue) {
                return mapOf(Pair(element, searchCount))
            }
        }

        return null
    }
}