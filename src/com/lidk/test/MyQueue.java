package com.lidk.test;

/**
 * 队列
 */
public class MyQueue {

    //队列
    private Object[] queue;
    //队列的头部，获取数据时总是从头部获取
    private int head;
    //队列尾部，push数据时总是从尾部添加
    private int tail;
    //队列长度
    private int size;
    //数组中能存放数据的最大容量
    private final static int MAX_CAPACITY = 1<<30;
    //数组长度
    private int capacity;
    //最大下标
    private int maxIndex;

    public MyQueue(int initialCapacity){
        if (initialCapacity > MAX_CAPACITY)
            throw new OutOfMemoryError("队列已满");
        if (initialCapacity <= 0)
            throw new IndexOutOfBoundsException();
        queue = new Object[initialCapacity];
        capacity = initialCapacity;
        maxIndex = initialCapacity - 1;
        head = tail = -1;
        size = 0;
    }
    public MyQueue(){
        queue = new Object[16];
        capacity = 16;
        head = tail = -1;
        size = 0;
        maxIndex = 15;
    }

    /**
     * 往队列尾部添加数据
     * @param object 数据
     */
    public void push(Object object){
        if (size >= capacity){
            return;
        }
        if (++tail > maxIndex){
            tail = 0;
        }
        queue[tail] = object;
        size++;
    }

    /**
     * 从队列头部拉出数据
     * @return 返回队列的第一个数据
     */
    public Object pop(){
        if (size <= 0){
            return null;
        }
        if (++head > maxIndex){
            head = 0;
        }
        size--;
        Object old = queue[head];
        queue[head] = null;
        return old;
    }

    /**
     * 查看第一个数据
     * @return
     */
    public Object peek(){
        return queue[head + 1];
    }




    /**
     * 清空队列
     */
    public void empty(){
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        tail = head = -1;
        size = 0;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push("12");
        System.out.println(myQueue.peek());

    }

}
