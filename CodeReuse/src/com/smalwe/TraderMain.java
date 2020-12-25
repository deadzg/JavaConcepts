package com.smalwe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderMain {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println(findAndSortTrans(2011, transactions));
        System.out.println(uniqueCities(transactions));
        System.out.println(findTraders(transactions, "Cambridge"));
        System.out.println(tradersNameSort(transactions));
        System.out.println(anyTraderBasedInGivenCity(transactions, "Milan"));
        printAllTransaction(transactions, "Cambridge");
        System.out.println(highestVal(transactions));
        System.out.println(smallestVal(transactions));
    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high)
     */
    public static List<Transaction> findAndSortTrans(int year, List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * What are all the unique cities where the traders work?
     */
    public static List<String> uniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Find all traders from Cambridge and sort them by name
     */
    public static List<Trader> findTraders(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * Return a string of all traders’ names sorted alphabetically
     */
    public static String tradersNameSort(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .reduce("", (a,b) -> a + " " + b);
        //.sorted.collect(joining())
    }

    /**
     * Are any traders based in Milan?
     */
    public static boolean anyTraderBasedInGivenCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> t.getCity().equals(city));
    }

    /**
     * Print all transactions’ values from the traders living in Cambridge
     */
    public static void printAllTransaction(List<Transaction> transactions, String city) {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .forEach(t -> System.out.println(t.getValue()));
    }

    /**
     * What’s the highest value of all the transactions?
     */
    public static int highestVal(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Math:: max);
    }

    /**
     * Find the transaction with the smallest value.
     */
    public static Transaction smallestVal(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
        // or
        //stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        //
    }


}
