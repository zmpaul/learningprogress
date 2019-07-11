package com.paul.algorithm;

/**
 * 求2个子串的最大连续相同子串
 * 思路：
 * 1.先看短的那个字符串是否在长的那个字符串中，如果存在，短的那个字符串就是最大共同子串
 * 2.如果不存在，那么就将短的那个子串进行长度递减的方式取子串，去长串中判断是否存在，如果
 * 存在，找到！
 * 
 * @ClassName: MaxSubString
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年6月4日 下午4:58:41
 */
public class MaxSubString {

    public static String maxSubString(String oneString, String twoString) {
        if (oneString.length() > twoString.length()) {
            // 交换
            String temp = oneString;
            oneString = twoString;
            twoString = temp;
        }
        int onelength = oneString.length();
        for (int i = 0; i < onelength; i++) {
            for (int a = 0, b = onelength - i; b != onelength + 1; a++, b++) {
                // 截取
                String subone = oneString.substring(a, b);
                if (twoString.contains(subone)) {
                    return subone;
                }
            }

        }
        return "";
    }

    public static void main(String[] args) {
        /*
         * System.out.println("请输入第一个字符串");
         * Scanner n1 = new Scanner(System.in);
         * String oneString = n1.next();
         * System.out.println("请输入第二个字符串");
         * Scanner n2 = new Scanner(System.in);
         * String twoString = n2.next();
         */
        System.out.println(maxSubString("abcdefghi", "zde"));
    }
}
