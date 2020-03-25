package com.smalwe.lambda;

public class Apple {
    private Integer wt;
    private String type;

    public Apple(Integer wt) {
        this.wt = wt;
    }

    public Integer getWt() {
        return wt;
    }

    public String toString() {
        return Integer.toString(this.getWt());
    }
}
