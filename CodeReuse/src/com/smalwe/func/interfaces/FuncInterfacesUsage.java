package com.smalwe.func.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Demonstrates the usage of functional interfaces
 * - https://www.baeldung.com/java-8-functional-interfaces
 * - https://dzone.com/articles/leveraging-lambda-expressions-for-lazy-evaluation
 */

public class FuncInterfacesUsage {

    public static void main(String[] args) {
        FuncInterfacesUsage instance = new FuncInterfacesUsage();

        Consumer<Long> printValue = v -> System.out.println("Value:" + v);
        instance.doSum(100L, 200L, printValue);

        Supplier<Double> val = () -> 35.4;
        System.out.println("Result for lazyPow:" + instance.lazyPow(val, 3));

        Function<String, Integer> foodLabelLogic = foodLabel ->  foodLabel.length();

        Map<String, Integer> labelMap = new HashMap<>();
        Integer labelVal = labelMap.computeIfAbsent("food", foodLabelLogic);
        System.out.println(labelVal);

        UnaryOperator<String> appendWithPrefix = (s) -> "unary-" + s;
        List<String> listOfStr = Arrays.asList("str1", "str2");
        listOfStr.replaceAll(appendWithPrefix);
        System.out.println(listOfStr);

    }

    public Long doSum(Long v1, Long v2, Consumer<Long> print) {
        print.accept(v1);
        print.accept(v2);
        return v1 + v2;
    }

    /**
     * Method to calculate the power.
     * Using supplier makes sure the caller do not have to precalculate the value, thus giving the flexiblity
     * of lazy loading (value generated only when the method is called)
     * @param val
     * @param pow
     * @return
     */
    public Double lazyPow(Supplier<Double> val , int pow) {
        return Math.pow(val.get(), pow);
    }



}
