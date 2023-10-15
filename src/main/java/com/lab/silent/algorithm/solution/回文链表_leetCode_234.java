package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class 回文链表_leetCode_234 {

    /**
     * 核心解法: 快慢指针,确定链表中间节点,链表反转之后再依次判断
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //定义快慢指针:
        ListNode fast = head,slow = head;
        //需要同时判断 fast及 next,因为fast每次前进两步
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果快指针走完后依然后依然不为空,则说明当前单链表为奇数,即slow最终停止的节点为当前链表的中点
        if(fast != null){
            slow = slow.next;
        }
        //反转slow链表
        slow = reverse(slow);
        fast = head;
        //根据中点之后的反转之后的链表与fast逐条对比,如果存在不一样的值,则说明当前链表不是回文链表
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
