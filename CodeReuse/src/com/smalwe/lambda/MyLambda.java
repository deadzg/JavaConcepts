package com.smalwe.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
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
}
