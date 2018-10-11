package com.paul.algorithm;

import java.util.Arrays;

/**
 * 桶排序
 * 
 * @ClassName: SimpleBucket
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2018年10月11日 下午3:54:05
 */
public class SimpleBucketSort {

    public static void main(String[] args) {
        int[] num = {1, 98, 8, 4};
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        int[] realNum = new int[max + 1];
        for (int i = 0; i < num.length; i++) {
            realNum[num[i]] = num[i];
        }
        System.out.println(Arrays.toString(realNum));
    }
}
