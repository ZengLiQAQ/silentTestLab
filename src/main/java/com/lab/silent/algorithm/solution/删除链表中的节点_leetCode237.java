package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

public class 删除链表中的节点_leetCode237 {
    /**
     * 注意: 删除给定的节点。并不是指从内存中删除它,
     * @param head 需要删除的节点
     */
    public  static  void deleteNode(ListNode head) {
        head.val = head.next.val;
        head.next = head.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        deleteNode(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
