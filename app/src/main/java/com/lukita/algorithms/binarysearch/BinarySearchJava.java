package com.lukita.algorithms.binarysearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(log n) Algorithm
public class BinarySearchJava {

    static int searchCount = 0;

    public static Map<Integer, Integer> findValue(
            List<Integer> sortedList,
            int targetValue,
            int startIndex,
            int endIndex
    ) {
        int midIndex = (startIndex + endIndex) / 2;
        int midValue = sortedList.get(midIndex);

        if (startIndex > endIndex) return Collections.emptyMap();; // If isEmpty(), the target was not found

        if (targetValue == midValue) {
            searchCount++;
            return new HashMap<>(targetValue, searchCount);
        }

        if (targetValue < midValue) {
            return findValue(sortedList, targetValue, startIndex, midIndex - 1);
        } else {
            return findValue(sortedList, targetValue, midIndex + 1, endIndex);
        }
    }
}
