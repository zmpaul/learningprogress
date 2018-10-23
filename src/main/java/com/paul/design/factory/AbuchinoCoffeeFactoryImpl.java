package com.paul.design.factory;


public class AbuchinoCoffeeFactoryImpl implements SimpleCoffeeFactory {

    public Coffee getCoffeeNoKey() {
        return new Abuchino();
    }
}
