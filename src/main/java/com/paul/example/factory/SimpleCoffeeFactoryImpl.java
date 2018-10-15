package com.paul.example.factory;


public class SimpleCoffeeFactoryImpl implements SimpleCoffeeFactory {

    public Coffee getCoffee(String coffeeType) {
        if ("Abuchino".equals(coffeeType)) {
            return new Abuchino();
        }
        else if ("Latte".equals(coffeeType)) {
            return new Latte();
        }
        return null;
    }

    public static void main(String[] args) {
        Coffee abuchinoCoffee = new SimpleCoffeeFactoryImpl().getCoffee("Abuchino");
        System.out.println(abuchinoCoffee.price());
        Coffee latteCoffee = new SimpleCoffeeFactoryImpl().getCoffee("Latte");
        System.out.println(latteCoffee.price());
    }
}
