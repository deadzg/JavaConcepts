package com.smalwe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class covers the basic use case for stream APIs
 */
public class StreamUsables {

    /**
     * Method to filter the list of dishes based on calories count and sort them with lowest calorie first
     */
    public static List<String> lowCalDishNames(int calThreshold, List<Dish> dishes) {
        return dishes
                .stream()
                .filter(d -> d.getCal() <= calThreshold)
                .sorted(Comparator.comparing(Dish :: getCal))
                .map(Dish :: getName).collect(Collectors.toList());
    }

    /**
     * Given a list of words, you’d like to return a list of the number of characters for each word.
     */
    public static List<Integer> charactersInEachWord(String input) {
        return Arrays.asList(input.split(" ")).stream().map(String::length).collect(Collectors.toList());
    }

    /**
     * Usage: Flatmap
     * Converts multiple streams into single stream
     * return a list of all the unique characters for a list of words
     */
    public static void uniqueChars(String[] words) {
        System.out.println( Arrays.asList(words)
                .stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));
    }

    /**
     * Given a list of numbers, return squares of each number
     */
    public static void squareOfListNum(Integer[] nums) {
        Arrays.asList(nums)
                .stream()
                .map(num -> Math.multiplyExact(num, num))
                .collect(Collectors.toList());
    }

    /**
     *  Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.
     */
    public static void allPairs(Integer[] numsA, Integer[] numsB) {
        List<Integer[]> rs = (Arrays.asList(numsA)
                .stream()
                .flatMap( i -> Arrays.asList(numsB).stream().map( j -> new Integer[] {i, j}))
                .collect(Collectors.toList()));
        rs.stream().forEach( r -> System.out.println(r[0] + "->" + r[1]));
    }

}
