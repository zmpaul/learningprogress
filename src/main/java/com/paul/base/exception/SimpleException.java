package com.paul.base.exception;


public class SimpleException {

    public static String excute() {
        try {
            int b = 6 / 0;
            return "no";
        } catch (Exception e) {
            return "exception";
        }
        finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(excute());
    }
}
