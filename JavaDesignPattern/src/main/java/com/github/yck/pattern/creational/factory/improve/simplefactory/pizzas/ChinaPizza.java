package com.github.yck.pattern.creational.factory.improve.simplefactory.pizzas;

public class ChinaPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("ChinaPizza is prepared.");
    }
}