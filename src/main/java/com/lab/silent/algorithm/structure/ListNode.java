package com.lab.silent.algorithm.structure;/**
 * Created by zengli on 2020/11/26.
 */


/**
 * @ClassName ListNode
 * @Description 单向链表
 * @Author ZengLi
 * @Date 2020/11/26 17:39
 * @VerSion 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
