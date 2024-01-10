package com.lab.silent.algorithm.byteDanceSpecialty;

import com.lab.silent.algorithm.structure.ListNode;

/**
 * @author gouqi
 * @version 1.0
 * @description: 超高出现频率题-8次
 *      反转链表
 * @date 2024/1/11 00:58
 */
public class MyTest_206 {


    /**
     * 题目: 反转链表
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //创建反转链表测试数据
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //调用反转链表方法
        ListNode reverse = reverseList(head);
        //打印reverse的值
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    /**
     * 反转链表:
     * 实现概述:
     * 1. 定义一个pre节点, 用于保存当前节点的前一个节点
     * 2. 定义一个cur节点, 用于保存当前节点
     * 3. 定义一个next节点, 用于保存当前节点的下一个节点
     * 4. 循环条件: cur不为空
     * 5. 循环体:
     * 5.1 保存当前节点的下一个节点
     * 5.2 保存当前节点的前一个节点
     * 5.3 保存当前节点
     * 5.4 保存当前节点的下一个节点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归的方式实现:
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        //定义递归终止条件
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }


}
