package com.paul.algorithm;

/*
 * 斐波那契数列：1 2 3 5 8...
 * 从第三项开始,值是前两项之和
 */
public class FibonacciSequence {
    static int fibonacci(int a) {
        if (a == 2 || a == 1) {
            return 1;
        }
        return fibonacci(a - 2) + fibonacci(a - 1);
    }
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
