package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 环形链表_leetCode141 {

    /**
     * 通过set 暴力解法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        while(curr.next != null){
            if(set.contains(curr.hashCode())){
                return true;
            }else{
                set.add(curr.hashCode());
                curr = curr.next;
            }
        }
        return false;
    }

    /**
     * 通过快慢双指针,空间复杂度O(1) 解法
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            //快指针能到达终点null,即表明不存在环,因为快指针每次前进两步,需要同时判断 fast 及 fast.next
            if(fast == null || fast.next == null){
                return false;
            }
            //根据题意补充
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 判断链表是否存在环
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head){
        if(head == null){
            return  false;
        }
        ListNode slow = head , fast = head.next;
        while (slow != fast){
            if(fast == null && fast.next == null){
                return  false;
            }
            //移动指针
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
