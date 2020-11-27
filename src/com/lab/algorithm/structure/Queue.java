package com.lab.algorithm.structure;


/**
 * @创建人: zengli
 * @描述 队列及其java实现, FIFO (first in first out)
 */
public class Queue<E> {
    private Object[] data = null;
    //队列的容量
    private int maxSize;
    //队列头的指针,允许删除(出列),队列头,虽然为数组的一个元素,但是删除之后,该数组0位的元素为null了,此时的队列头为1位的元素
    private int front;
    //队列尾的指针,允许插入(入列)
    private int rear;

    public Queue() {
        this(10);
    }

    public Queue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0:" + initialSize);
        }
    }

    //在队尾插入数据(入队)
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满,无法插入心得元素!");
        } else {
            data[rear++] = e;
            return true;
        }
    }


    //删除对头元素,出队
    public E poll() {
        if (data.length == 0) {
            throw new RuntimeException("空队列");
        }
        //临时保存队列front端的元素的值
        E value = (E) data[front];
        //释放队列front端的元素,同时将队头的指针加1
        data[front++] = null;
        return value;
    }

    //去除队列头部的元素,不删除
    public E peek(){
        if(data.length == 0){
            throw new RuntimeException("空队列异常!");
        }
        return (E) data[front];
    }
}
