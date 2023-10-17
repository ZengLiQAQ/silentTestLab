package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

public class 合并K个有序链表_leetCode_23 {
    /**
     * 通过分治的思想,将k个链表合并的问题拆解为,多次2个链表合并的问题--迭代
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int len = lists.length;
        //只要还未全部合并完成就需要继续合并
        while(len > 1){
            //两两合并之后的链表数组长度
            int sonLen = 0;
            //因为是两两合并,i每次+2
            for(int i= 0; i < len; i+=2){
                if(i == len-1){
                    //如果是最后一个元素了,则无法找到i+1的链表去合并了,所有直接将最后元素的链表放在sonLen++的位置上,由下一次循环时,去合并
                    lists[sonLen++] = lists[i];
                }else{
                    lists[sonLen++] = merge2Lists(lists[i],lists[i+1]);
                }
            }
            //每次两两合并之后,最终k的链表会缩减到sonLen
            len = sonLen;
        }
        return lists[0];
    }

    //合并两个升序列表
    public ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                //链表1的指针前移一位
                l1 = l1.next;
            }else{
                curr.next = l2;
                //链表1的指针前移一位
                l2 = l2.next;
            }
            //返回结果指针前进一位
            curr = curr.next;
        }
        //如果循环完成之后,如果存在某个值是null,则将另一个链表全部连到curr
        curr.next = l1 == null ? l2:l1;
        return pre.next;
    }

    /**
     * 递归实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int start,int end){
        //定义终止条件,如果开始截止位置一致,则说明已经递归到最低层的最后一次合并了,或者是最后一个链表元素了
        if(start == end){
            return lists[start];
        }
        int mid = start + (end-start)/2;
        ListNode l1 = merge(lists,start,mid);
        ListNode l2 = merge(lists,mid+1,end);
        //合并两个链表
        return  merge2Lists2(l1,l2);
    }



    //合并两个升序列表-递归
    public ListNode merge2Lists2(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next =  merge2Lists2(l1.next,l2);
            return l1;
        }else{
            l2.next =  merge2Lists2(l1,l2.next);
            return l2;
        }
    }
}
