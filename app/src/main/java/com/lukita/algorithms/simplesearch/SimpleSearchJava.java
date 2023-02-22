package com.lukita.algorithms.simplesearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(n) Algorithm
public class SimpleSearchJava {

    public static <T extends Comparable<T>>Map<Integer, Integer> findValue(List<T> sortedList, T targetValue) {
        int searchCount = 0;

        for (int i = 0; i < sortedList.size(); i++) {
            T element = sortedList.get(i);
            searchCount++;

            if (element == targetValue ) return new HashMap<>(i, searchCount);
        }

//        Different approach, even tho this way we cannot receive type T
//        for (int element : sortedList) {
//            searchCount++;
//
//            if (element == targetValue) return new HashMap<>(element, searchCount);
//        }

        return Collections.emptyMap();
    }
}
