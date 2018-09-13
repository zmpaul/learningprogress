package com.paul.algorithm;

import java.util.Arrays;
/**
 * 数组右移K位
 *
 */
public class ArrayRightMove {
		public static void main(String[] args) {
			 int[] array  = {1,2,3,4,5,6,7};
			 int k  = 3;
			 //7 6 5 4 3 2 1 
			 //5 6 7 4 3 2 1
			 // 5 6 7 1 2 3 4 
			 for (int i = 0; i < array.length/2; i++) {
				int temp = array[i];
				array[i] = array[array.length-i-1];
				array[array.length-i-1] = temp;
			}
			 System.out.println(Arrays.toString(array));
			 for (int i = 0; i < k/2; i++) {
				 int temp = array[i];
				 array[i] = array[k-i-1];
				 array[k-i-1] = temp;
			}
			 System.out.println(Arrays.toString(array));
			 //3 7-3+2
			 //4 7-4+2
			 for (int j = 0; j <(array.length-k)/2 ; j++) {
				 int temp = array[j+k];
				 array[j+k] = array[array.length-j-1];
				 array[array.length-j-1] = temp;
			}
			 System.out.println(Arrays.toString(array));
		}

}
