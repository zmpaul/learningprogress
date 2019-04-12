package com.paul.base.structure;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 数组实现简单栈 java.util.Stack;
 * 
 * @ClassName: BaseStack
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年4月3日 上午11:16:20
 */
public class BaseStack<T> {

    private int top;// top指针
    private int maxsize;// 栈满
    private T data[];
    private int size;
    public BaseStack(int maxsize) {
        this.maxsize = maxsize;
        data = (T[]) new Object[maxsize];
        this.top = -1;
    }

    private boolean isFull() {
        if (top == maxsize - 1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
    private boolean push(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        top++;
        data[top] = value;
        return true;
    }

    private int size() {
        this.size = top + 1;
        return size;
    }
    private T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T t = data[top];
        top--;
        return t;
    }

    private T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    public String toString() {
        return " stack 大小是 " + Arrays.toString(data);
    }

    public static void main(String[] args) {
        BaseStack<String> baseStack = new BaseStack<String>(4);
        baseStack.push("1");
        System.out.println(" 栈顶 " + baseStack.peek());
        baseStack.push("2");
        System.out.println(" 栈顶 " + baseStack.peek());
        baseStack.push("3");
        baseStack.push("4");
        System.out.println(baseStack.pop());
    }
}
