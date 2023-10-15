package com.lab.silent.algorithm.structure;

import java.util.Stack;

/**
 * 用栈实现队列:
 *  栈: LIFO
 *  队列: FIFO
 */
public class MyQueue<E> {
    Stack<E> in = new Stack<>();
    Stack<E> out = new Stack<>();
    int size = 0;


    public MyQueue() {

    }

    public void push(E x) {
        in.push(x);
    }

    public E pop() {
        if(out.empty()){
            moveToOut();
        }
        return  out.pop();
    }

    public void moveToOut(){
        while (!in.empty()){
            out.push(in.pop());
        }
    }

    public E peek() {
        if(out.empty()){
            moveToOut();
        }
        return  out.peek();
    }

    public boolean empty() {
        return  in.empty() && out.empty();
    }
}
