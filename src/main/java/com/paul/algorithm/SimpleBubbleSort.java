package com.paul.algorithm;

import java.util.Arrays;

/**
 * 简单冒泡
 * 
 * @ClassName: SimpleBubble
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2018年10月11日 下午3:54:19
 */
public class SimpleBubbleSort {

    public static void main(String[] args) {
        int[] a = {10, 8, 13, 11, 3};
        // sort(a);
        int[] b = {10, 9, 8, 7, 6};
        sort2(b);
    }

    /**
     * ？？算法
     * @Title: sort
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param a
     * @throws
     */
    private static void sort(int[] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                k++;
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    System.out.println(a[j] + " 与  " + a[i] + " 交换 " + Arrays.toString(a));
                }
            }
        }
        System.out.println(k);
    }

    /**
     * 冒泡
     * @Title: sort2
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param a
     * @throws
     */
    /*
     * private static void sort2(int[] a) {
     * int k = 0;
     * for (int i = 0; i < a.length; i++) {
     * for (int j = 0; j < a.length - i; j++) {
     * k++;
     * if (j + 1 >= a.length) {
     * continue;
     * }
     * if (a[j] > a[j + 1]) {
     * int temp = a[j];
     * a[j] = a[j + 1];
     * a[j + 1] = temp;
     * System.out.println(a[j + 1] + " 与  " + a[j] + " 交换 " + Arrays.toString(a));
     * }
     * }
     * }
     * System.out.println(k);
     * }
     */

    private static void sort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (j + 1 >= a.length) {
                    continue;
                }
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    System.out.println(a[j + 1] + " 与  " + a[j] + " 交换 " + Arrays.toString(a));
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
