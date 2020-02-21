package com.smalwe;

public  class Person implements Comparable<Person>{
    int age;
    int salary;

    public Person(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Person p) {
        if (this.age > p.age) return 1;
        if (this.age < p.age) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Age:" + this.age;
    }
}