package com.solvd.lawfirm;

import java.util.*;

public class WordsCounting {

    public static Map<String, Integer> sortByComparator(Map<String, Integer> words) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(words.entrySet());

        Comparator<Map.Entry<String, Integer>> compareWords = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        list.sort(compareWords);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        list.forEach((k) -> sortedMap.put(k.getKey(), k.getValue()));

        return sortedMap;
    }
}
