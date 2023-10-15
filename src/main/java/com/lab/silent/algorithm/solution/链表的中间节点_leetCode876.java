package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

public class 链表的中间节点_leetCode876 {
    /**
     * 使用快慢指针的方式获取中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
