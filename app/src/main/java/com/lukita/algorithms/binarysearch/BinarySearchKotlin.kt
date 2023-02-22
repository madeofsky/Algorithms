package com.lukita.algorithms.binarysearch

// O(log n) Algorithm
class BinarySearchKotlin {

    private var searchCount: Int = 0

    fun <T: Comparable<T>> findValue(
        sortedList: List<T>,
        targetValue: T,
        startIndex: Int = 0,
        endIndex: Int = sortedList.size - 1
    ): Map<Int, Int>? {

        val midIndex = (startIndex + endIndex) / 2
        val midValue = sortedList[midIndex]

        if (startIndex > endIndex) return null

        return when {
            targetValue == midValue -> {
                searchCount++
                mapOf(Pair(midIndex, searchCount))
            }
            targetValue < midValue -> {
                findValue(sortedList, targetValue, startIndex, midIndex - 1)
            }
            else -> {
                findValue(sortedList, targetValue, midIndex + 1, endIndex)
            }
        }
    }
}