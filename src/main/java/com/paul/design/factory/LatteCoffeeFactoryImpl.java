package com.paul.design.factory;


public class LatteCoffeeFactoryImpl implements SimpleCoffeeFactory {
    public Coffee getCoffeeNoKey() {
        return new Latte();
    }

}
