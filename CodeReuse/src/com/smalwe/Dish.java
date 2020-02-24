package com.smalwe;

public class Dish {
    private int cal;
    private String name;

    public Dish(int cal, String name) {
        this.cal = cal;
        this.name = name;
    }

    public int getCal() {
        return cal;
    }

    public String getName() {
        return name;
    }
}
