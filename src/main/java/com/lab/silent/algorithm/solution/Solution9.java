package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import java.util.LinkedList;

/**
 * @ClassName Solution9
 * @Description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 主要的思想是：
 * <p>
 * stack_in只负责进入
 * stack_out只负责取出
 * 只有stack_out为空时才把stack_in的所有元素倾倒进stack_out中，这样顺序就不会乱了
 * @Author ZengLi
 * @Date 2020/11/27 15:25
 * @VerSion 1.0
 **/
public class Solution9 {
    /**
     * 声明两个栈,in用来入,out,用来出
     */
    LinkedList<Integer> in, out;
    /**
     * 当前队列的元素数量
     */
    int size;

    public Solution9() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    /**
     * 入队,每次排在队列尾
     *
     * @param value
     */
    public void appendTail(int value) {
        in.push(value);
        size++;
    }

    /**
     * 出队,取最前一个
     *
     * @return
     */
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        //将in栈倒腾到out中去,用作排队
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        size --;
        return out.pop();
    }

    public static void main(String[] args) {
        Solution9 queue = new Solution9();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }
}
