package com.lab.silent.algorithm.structure;

/**
 * @创建人: zengli
 * @描述 基于数组实现的顺序栈: FILO(first in last out)
 */
public class Stack<E> {
    private Object[] data = null;
    //栈的容量
    private int maxSize = 0;
    //栈顶的指针
    private int top = -1;

    //构造函数
    Stack() {
        this(10);
    }

    Stack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0:" + initialSize);
        }
    }

    //入栈
    public boolean push(E e) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满,无法将元素入栈");
        }
        data[++top] = e;
        return true;

    }

    //出栈
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("空栈");
        }
        return (E) data[top--];
    }

    //查询栈顶元素
    public E peek(){
        if (top == -1) throw  new RuntimeException("空栈");
        return (E)data[top];
    }
}
