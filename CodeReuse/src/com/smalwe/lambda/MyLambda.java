package com.smalwe.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLambda {

    public static void main(String[] args) throws Exception {
        Apple a1 = new Apple(10);
        Apple a2 = new Apple(1);
        Apple a3 = new Apple(100);
        Apple a4 = new Apple(84);

        List<Apple> listapples = Arrays.asList(a1, a2, a3, a4);

        Comparator<Apple> byWeightNorwal = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWt().compareTo(o2.getWt());
            }
        };

        Comparator<Apple> byWeightLm = (Apple o1, Apple o2) -> o2.getWt().compareTo(o1.getWt());

        listapples.stream().forEach(System.out::println);
        System.out.println("======");

        listapples.stream()
                .sorted(byWeightNorwal)
                .forEach(System.out::println);
        System.out.println("======");

        listapples.stream()
                .sorted(byWeightLm)
                .forEach(System.out::println);


        Runnable r1 = () -> System.out.println("Runnable r1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable r2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Runnable r3"));

        processCall(()->  a1);
        System.out.println(fetch().call());

        Predicate<Apple> p = (Apple a) -> a.getWt() > 10;

        // Read single line
        System.out.println(processFile((BufferedReader::readLine)));

        // Read two lines
        System.out.println(processFile((BufferedReader br) ->  br.readLine() + br.readLine()));

        Predicate<String> nonEmptyStringPred = (s) -> !s.isEmpty();

        List<String> nonEmpty = filter(Arrays.asList("adf", "", "ddddd"), nonEmptyStringPred);
        System.out.println(nonEmpty.size());

        Consumer<Integer> printAllIntegers = (i) -> System.out.print(i);
        myForEach(Arrays.asList(1,2,3), printAllIntegers);

        Function<String, Integer> stringToLenFun = (String s) -> s.length();
        System.out.println(myMap(Arrays.asList("dddd", "ffff", "dd"), stringToLenFun));

        List<String> slist = Arrays.asList("abc", "wdf", "aee");

        slist.sort((s1,s2)-> s1.compareToIgnoreCase(s2));
        // or
        slist.sort(String::compareToIgnoreCase);

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        // or
        Function<String, Integer> stringToIntegerNew = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        // or
        BiPredicate<List<String>, String> containsNew = List::contains;
    }

    public static void process(Runnable r) {
        r.run();
    }

    public static void processCall(Callable r) throws Exception {
        r.call();
    }

    public static Callable<String> fetch() {
        return () -> "Callable call input";
    }

    public static String processFile(BufferredReaderProcessor p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mydata.txt"));
        return p.process(br);
    }

    public static <T> List<T> filter (List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    public static <T> void myForEach(List<T> list, Consumer<T> c) {
        for(T t : list) {
            c.accept(t);
        }
    }

    public static <T,R> List<R> myMap(List<T> list, Function<T,R> f) {
        List<R> rs = new ArrayList<>();
        for(T t: list) {
            rs.add(f.apply(t));
        }
        return rs;
    }
}
