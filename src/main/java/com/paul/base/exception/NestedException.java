package com.paul.base.exception;

/**
 * i=2
 * i=1
 * testEx2, catch exception
 * testEx2, finally; return value=false
 * testEx1, finally; return value=false
 * testEx, finally; return value=false
 * 
 * @ClassName: TestException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年3月28日 下午5:53:39
 */
public class NestedException {
    public NestedException() {
    }
 
    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }
 
    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }
 
    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        }
        finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }
 
    public static void main(String[] args) {
        NestedException testException1 = new NestedException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
