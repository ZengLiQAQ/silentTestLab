package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

import java.util.List;

public class 返回倒数第K个节点_LeetCode_面试题02 {
    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 核心: 双指针:
     *      第一个指针先移动k步，
     *      然后第二个指针再从头开始，这个时候这两个指针同时移动，
     *      当第一个指针到链表的末尾的时候，返回第二个指针即可
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode p = head,q = head;
        while (k-- > 0){
            p = p.next;
        }
        //两个指针同时前进
        while(p != null){
            p = p.next;
            q = q.next;
        }
        return q.val;
    }
}
