package com.paul.algorithm;

import java.util.Scanner;

/**
 * 打印指定的所有质因子
 * 
 * @ClassName: PrimeNumber
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年6月3日 下午5:30:23
 */
public class PrimeNumber {

    public static String printPrimeNumber(int number) {
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
                return printPrimeNumber(number / i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println("请输入整数");
        Scanner n = new Scanner(System.in);
        int nextValue = Integer.parseInt(n.next());
        printPrimeNumber(nextValue);
    }
}
