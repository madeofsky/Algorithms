package com.lukita.algorithms.simplesearch

// O(n) Algorithm
class SimpleSearchKotlin {

    fun <T: Comparable<T>>findValue(sortedList: List<T>, targetValue: T): Map<T, Int>? {
        var searchCount = 0

        for (element in sortedList) {
            searchCount++

            if (element == targetValue) {
                return mapOf(Pair(element, searchCount))
            }
        }

//        forEach approach
//        sortedList.forEach { element ->
//            searchCount++
//            if (element == targetValue) {
//                return mapOf(Pair(element, searchCount))
//            }
//        }

        return null
    }
}