package com.paul.algorithm;


public class Random {

    static int Rand() {
        int i1 = Rand();
        int i2 = Rand();
        if (i1 == 0 && i2 == 1)
            return 1;
        else if (i1 == 1 && i2 == 0)
            return 0;
        else
            return Rand();
    }

    public static void main(String[] args) {
        System.out.println(Rand());;
    }
}
