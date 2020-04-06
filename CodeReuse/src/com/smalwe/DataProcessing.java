package com.smalwe;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

    /**
     * Sort map by Object key
     */
    public static Map<Person, String> sortMapByPersonKey(Map<Person, String> inputMap) {
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

    public static Map<String, String> sortMapByValue(Map<String, String> inputMap) {
        Map<String, String> outputMap = inputMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        return outputMap;
    }

    /**
     * Ref: https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
     * @param input
     */
    public static void regexMatcher(String input) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(input);

        while(m.find()) {
            System.out.println("Index start:" + m.start());
            System.out.println("Index end:" + m.end());
            System.out.println(m.group());
        }

        // replace the matcher group
        Pattern rp = Pattern.compile("\\s+");
        Matcher rm = rp.matcher(input);
        System.out.println(rm.replaceAll("\t"));
    }

    public static void mapTraverse(Map<Person, String> input) {
        input.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });
    }

    public static void findWordCount(String input) {
        System.out.println(Arrays.asList(input.split(" ")).stream().collect(Collectors.groupingBy(e -> e.toLowerCase(), Collectors.counting())));
    }

    public static List<Person> sortListOnCustomRule(List<Person> plist) {
        return plist.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static Queue<Project> convertRelatedArrayToPriorityQueue(int[] Profits, int[] Capital) {
        Comparator<Project> cCapital = (a,b) -> a.getCapital().compareTo(b.getCapital());
        Comparator<Project> cProfit = (a,b) -> b.getProfit().compareTo(a.getProfit());
        Queue<Project> projectListByCapital = IntStream.range(0, Capital.length)
                .mapToObj(i -> new Project(Capital[i], Profits[i]))
                .collect(Collectors.toCollection(() -> new PriorityQueue<Project>(cCapital)));

        return projectListByCapital;
    }

    public static String convertCharArrayToString(char[] ca) {
        return new String(ca);
    }

    public static Map<String, List<Integer>> inverseMap(Map<Integer, String> mapStrs) {
        Map<String, List<Integer>> inverseMap = mapStrs.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        return inverseMap;
    }



}
