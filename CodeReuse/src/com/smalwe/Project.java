package com.smalwe;

public class Project {
    private int capital;
    private int profit;
    Project(int c,int p)
    {
        this.capital=c;
        this.profit=p;
    }

    public Integer getCapital() {
        return capital;
    }

    public Integer getProfit() {
        return profit;
    }
}
