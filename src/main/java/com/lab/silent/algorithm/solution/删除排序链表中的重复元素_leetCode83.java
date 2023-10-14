package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;
import com.lab.silent.algorithm.structure.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 删除排序链表中的重复元素_leetCode83 {


    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }


    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        while(curr.next != null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
         return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3))));

        ListNode node =deleteDuplicates(head);
        System.out.println(JSONObject.toJSONString(node));
    }

}
