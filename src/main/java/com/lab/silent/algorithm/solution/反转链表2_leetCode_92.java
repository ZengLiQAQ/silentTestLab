package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

public class 反转链表2_leetCode_92 {

    /**
     * 思路:
     * 找到 left -> right 的链表,将对应的链表反转,再拼接回原链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义伪头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        //定义当前指针,从伪头结点开始
        ListNode cur = pre;
        //定义需要反转的子链表的头节点的上一个节点
        ListNode sonHeadBefore = null;
        //定义需要反转的子链表的尾节点
        ListNode sonTial = null;
        //定义需要反转的子链表的尾节点的下一个节点
        ListNode nextHead = null;
        //定义位置索引
        int idx = 0;
        while(idx <= right){
            //找到需要反转的子链表的头结点的前一个节点
            if(idx == (left-1)){
                sonHeadBefore = cur;
            }
            //扎到需要反转的子链表的尾结点,用于反转是临时断开next
            if(idx == (right-1)){
                sonTial = cur.next;
            }
            //找到后续需要接上的节点
            if(idx == right){
                nextHead = cur.next;
            }
            //位置加一
            idx++;
            //移动指针
            cur = cur.next;
        }
        //断开需要反转的子链表的尾结点的next值开
        sonTial.next = null;
        //反转前的头结点,也是反转后的尾
        ListNode tmpHead = sonHeadBefore.next;
        //反转子链表
        ListNode sonReverse = reverse(sonHeadBefore.next);
        //拼接回原链表
        sonHeadBefore.next = sonReverse;
        tmpHead.next = nextHead;
        return pre.next;
    }


    /**
     * 反转链表
     */
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}