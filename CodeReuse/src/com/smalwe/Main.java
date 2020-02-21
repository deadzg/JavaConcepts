package com.smalwe;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        DataProcessing dp = new DataProcessing();

        Map<String, String> inputMapForSortMapByKey = new HashMap<>();
        inputMapForSortMapByKey.put("country1", "India");
        inputMapForSortMapByKey.put("country2", "UK");
        inputMapForSortMapByKey.put("3country", "France");
        inputMapForSortMapByKey.put("doc", "India");

        System.out.println(dp.sortMapByKey(inputMapForSortMapByKey));
    }
}
