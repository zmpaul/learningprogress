package com.paul.algorithm;

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
        int[] num = {1, 10, 8, 4, 4};
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        int[] realNum = new int[max + 1];
        // 计数
        for (int j = 0; j < num.length; j++) {
            realNum[num[j]]++;
        }
        // 升序 挨个输出
        for (int k = 0; k < realNum.length; k++) {
            // realNum[k] 出现次数
            for (int i = 0; i < realNum[k]; i++) {
                System.out.print(k + " ");
            }

        }
    }
}
