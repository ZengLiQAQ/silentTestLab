package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

public class 合并两个有序链表_leetCode21 {

    /**
     * 合并两个升序链表:
     *   核心思路: 每次对比一个链表的头节点,值小的参与拼接返回结果并移除该头结点,最后还剩下的链表及直接作为next即可
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //定义伪头结点
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                //链表1移除已对比的头结点
                list1 = list1.next;
            }else{
                curr.next = list2;
                //链表2移除已对比的头结点
                list2 = list2.next;
            }
            //指针移动到下一位
            curr = curr.next;
        }
        //其中一个列表遍历结束之后,其中没遍历完的链表直接作为next即可
        curr.next = list1 != null ? list1 : list2;
        return ans.next;
    }

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //如果链表1的val 小于 链表2的val 则使用链表1的next作为链表1参与下次对比,否则使用链表2的next节点
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

}
