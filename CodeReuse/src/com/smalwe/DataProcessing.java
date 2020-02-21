package com.smalwe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * This class list down some common methods which can be refferred/reused while solving any Java related data problems
 */
public class DataProcessing {

    /**
     * Sort a map by key of type String
     */
    public static Map<String, String> sortMapByKey(Map<String, String> inputMap) {
        Map sortedMap = inputMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue(),
                                (e1, e2) -> e2,
                                LinkedHashMap::new)
                );
        return sortedMap;

    }
}
