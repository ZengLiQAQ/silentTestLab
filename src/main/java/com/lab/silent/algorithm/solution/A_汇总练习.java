package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

/**
 * @author gouqi
 * @version 1.0
 * @description: TODO
 * @date 2023/11/7 11:20
 */
public class A_汇总练习 {
    /**
     * 找到链表的中间节点: 双指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     * 链表反转:
     */
    public ListNode reverseListNode(ListNode head){
        //定义递归终止条件: 最后一个节点是的next是null,表示是最终一个节点
        if(head == null || head.next == null){
            return  head;
        }
        //逐层递归链表
        ListNode p  = reverseListNode(head.next);
        //替换前后链表的指向
        head.next.next = head;
        head.next = null;
        //返回最深一层的链表节点
        return p;
    }

    /**
     * 返回倒数第K个节点的值:
     * k = 2
     *  1 ,3, 5, 6, 9
     *  |------|--|
     *  返回倒数第K个节点,使用双指针,第一个指针右移到第K个位置时,第二个指针开始右移,第一个指针到头时,第二个指针的位置就是倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public  int kthToLast(ListNode head, int k){
        ListNode first = head;
        ListNode sec = head;
        int cnt = 1;
        while (first.next != null){
            first = first.next;
            if(cnt >= k){
                sec = sec.next;
            }
            cnt++;
        }
        return sec.val;
    }
}
