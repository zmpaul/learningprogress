package com.paul.design.factory;


public class MainFactoryTest {

    public static void main(String[] args) {
        Coffee abuchinoCoffee = new AbuchinoCoffeeFactoryImpl().getCoffeeNoKey();
        Coffee latteCoffee = new LatteCoffeeFactoryImpl().getCoffeeNoKey();
        System.out.println(abuchinoCoffee.price());
        System.out.println(latteCoffee.price());
    }
}
