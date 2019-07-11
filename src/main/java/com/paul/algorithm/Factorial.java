package com.paul.algorithm;

import java.math.BigInteger;

/**
 * 计算1024阶乘
 * BigInteger 用法.用int long 输出0
 * 
 * @ClassName: Factorial
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年6月3日 下午5:49:28
 */
public class Factorial {

    public static BigInteger factorial(int number) {
        BigInteger base = new BigInteger("1");
        //int base = 1;
        for (int i = 2; i <= number; i++) {
            base = base.multiply(new BigInteger(String.valueOf(i)));
            // base *= i;
        }
        return base;
    }

    public static void main(String[] args) {
        System.out.println(factorial(1024));;
    }
}
