package com.paul.base.structure;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

/**
 * 数组实现队列
 * 
 * @ClassName: baseQueue
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年4月4日 上午9:14:22
 * @param <E>
 */
public class BaseQueue<E> /* implements Queue<E> */ {
    private E[] queuedata;
    private int index;
    private int top;
    private BaseQueue(int initsize) {
        E[] es = (E[]) new Object[initsize];
        queuedata = es;
        this.index = -1;
        this.top = -1;
    }
    public int size() {
        if (index == -1) {
            return 1;
        }
        return this.index + 1;
    }

    public boolean isEmpty() {

        return this.index == 0 || this.index == -1;
    }

    public boolean isFull(){
        return this.index == queuedata.length - 1;
    }

    public boolean contains(Object o) {
        if (isEmpty()||o==null)
            return false;
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator() {
        if (isEmpty())
            return null;
        List<E> list = Arrays.asList(queuedata);
        return list.iterator();
    }

    public Object[] toArray() {
        if (isEmpty())
            return null;
        Object[] objects = new Object[] {(Object[]) queuedata};
        return objects;
    }

    // 入队尾
    public boolean push(E e) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        index++;
        queuedata[index] = e;
        // TODO Auto-generated method stub
        return true;
    }

    // 出队首
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top++;
        E e = queuedata[top];
        if (e == null) {
            throw new EmptyStackException();
        }
        return e;
    }

    public String toString() {
        return Arrays.toString(queuedata);
    }

    public static void main(String[] args) {
        BaseQueue<String> baseQueue = new BaseQueue<String>(4);
        baseQueue.push("111");
        System.out.println(baseQueue);
        baseQueue.push("222");
        System.out.println(baseQueue);
        System.out.println(baseQueue.pop());
        System.out.println(baseQueue.pop());
        System.out.println(baseQueue);
    }
}
