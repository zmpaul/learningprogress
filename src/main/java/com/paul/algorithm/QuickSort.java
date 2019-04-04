package com.paul.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 * 
 * @ClassName: QuickSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2018年10月11日 下午4:05:47
 */
public class QuickSort {

    private static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int base = a[left];
        // 引用
        int i = left;
        int j = right;
        while (i != j) {
            while (a[j] >= base && i < j) {
                j--;
            }
            while (a[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                System.out.print(Arrays.toString(a));
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                System.out.println(a[j] + "与" + a[i] + "互换--" + Arrays.toString(a));
            }
        }
        if (left != i) {
            System.out.print(Arrays.toString(a));
            a[left] = a[i];
            a[i] = base;
            System.out.println(a[i] + "与" + a[left] + "互换--" + Arrays.toString(a));
        }

        quickSort(a, left, i - 1);// 继续处理左边
        quickSort(a, i + 1, right);// 继续处理右边的
    }
    public static void main(String[] args) {
        int[] a = {16, 32, 75, 22, 68, 21, 6, 1, 2, 7, 12, 9, 3, 4, 5, 10, 8};
        int end = a.length - 1;
        quickSort(a, 0, end);
        System.out.println(Arrays.toString(a));
    }
}
