package com.paul.algorithm;

import java.util.HashSet;
import java.util.Set;
public class HappyNumber {
	static Set<Integer> set = new HashSet<Integer>();
	public static boolean isHappayNum(int num){
		while (num!=1) {
			int sum = 0 ;
			if (num>1&&num<10) {
				sum = (int) Math.pow(num, 2);
				System.out.println("num:"+num+" , sum = "+sum);
			}else if(num>=10&&num<100){
				int gewei = num%10;
				int shiwei = num/10;
				sum = (int)Math.pow(gewei, 2)+(int)Math.pow(shiwei, 2);
				System.out.println("shiwei:"+shiwei+" ,gewei: "+gewei+" , sum = "+sum);
			}else if(num>=100){
				int gewei = num%10;
				int baiwei = num/100;
				int shiwei = num/10%10;
				sum = (int)Math.pow(gewei, 2)+(int)Math.pow(baiwei, 2)+(int)Math.pow(shiwei, 2);
				System.out.println("baiwei:"+baiwei+" ,shiwei: "+shiwei+" ,gewei: "+gewei+" , sum = "+sum);
			}
			if(set.contains(sum)){
				return false;
			}
			set.add(sum);
			num = sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num  = 19;
		System.out.println(isHappayNum(num));
	}
}
