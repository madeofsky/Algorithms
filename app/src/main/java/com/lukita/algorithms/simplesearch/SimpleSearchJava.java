package com.lukita.algorithms.simplesearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(n) Algorithm
public class SimpleSearchJava {

    static Map<Integer, Integer> findValue(List<Integer> sortedList, int targetValue) {
        int searchCount = 0;

        for (int element : sortedList) {
            searchCount++;

            if (element == targetValue) return new HashMap<>(element, searchCount);
        }

        return Collections.emptyMap();
    }
}
