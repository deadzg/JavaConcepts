package com.smalwe;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        DataProcessing dp = new DataProcessing();

        Map<String, String> inputMapForSortMapByKey = new HashMap<>();
        inputMapForSortMapByKey.put("country1", "India");
        inputMapForSortMapByKey.put("country2", "UK");
        inputMapForSortMapByKey.put("3country", "France");
        inputMapForSortMapByKey.put("doc", "India");

        System.out.println(dp.sortMapByKey(inputMapForSortMapByKey));

        Person p1 = new Person(25, 1000);
        Person p2 = new Person(30, 4000);
        Person p3 = new Person(5, 2000);
        Map<Person, String> inputMapForSortMapByPersonKey = new HashMap<>();
        inputMapForSortMapByPersonKey.put(p1, "India");
        inputMapForSortMapByPersonKey.put(p2, "UK");
        inputMapForSortMapByPersonKey.put(p3, "France");

        System.out.println(dp.sortMapByPersonKey(inputMapForSortMapByPersonKey));

        String inputForRegexMatcher = "This is to test the to the regex matcher code This is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher codeThis is to test the to the regex matcher code";
        dp.regexMatcher(inputForRegexMatcher);

        List<Person> plist = new ArrayList<>();
        plist.addAll(Arrays.asList(p1, p2, p3));
        System.out.println(dp.sortListOnCustomRule(plist));

        dp.mapTraverse(inputMapForSortMapByPersonKey);


        dp.findWordCount(inputForRegexMatcher);
    }
}
