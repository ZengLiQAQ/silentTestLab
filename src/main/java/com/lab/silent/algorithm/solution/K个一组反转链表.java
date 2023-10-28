package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
public class K个一组反转链表 {
    /**
     * k个一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return  head;
        }
        //链表指针
        ListNode cur = head;
        //计算链表长度
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        //定义链表窗口的左右指针
        int left = 1;
        int right = left+k-1;
        //每次分组反转之后拼接时,都需要将已经反转的链表拼接会原链表中
        while (right <= len){
            //反转idx到idx+k位置的链表
            head = reverseByIdx(head,left,right);
            left = right+1;
            right = left+k-1;
        }
        return  head;
    }




    /**
     * 反转 left 到 right 位置的链表:
     *     找到子链表,将子链表反转,并将反转之后的链表与前后拼接起来
     */

    public ListNode reverseByIdx(ListNode head,int left ,int right){
        //定义虚拟头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        //定义指针(认为pre为0节点)
        ListNode cur = pre;
        //定义子链表的头结点 以及 前一个节点,
        ListNode sonHeadBefore = null;
        //定义子链表的尾节点
        ListNode sonTail = null;
        //定义子链表的尾节点的下一个节点
        ListNode sonTailAfter = null;
        //定义链表位置
        int idx = 0;
        //循环条件: 指针 <= right
        while(idx<= right){
            //找到子链表的头结点的前一个节点
            if(idx == left-1){
                sonHeadBefore = cur;
            }
            //找到子链表的尾节点
            if(idx == right-1){
                sonTail = cur.next;
            }
            //找到子链表的下一个节点
            if(idx == right){
                sonTailAfter = cur.next;
            }
            //移动链表位置指针
            idx++;
            //右移链表指针
            cur = cur.next;
        }
        //断开子链表尾节点的next指向
        sonTail.next = null;
        //临时记录子链表的头结点
        ListNode tmpHead = sonHeadBefore.next;
        //反转子链表
        ListNode sonReverse = reverse(sonHeadBefore.next);
        //重新将子链表拼接回原链表中
        sonHeadBefore.next = sonReverse;
        //这里记录的子链表的头结点,实际上就是反转链表之后的尾节点
        tmpHead.next = sonTailAfter;
        return pre.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        //定义终止条件
        if(head == null || head.next == null){
            return  head;
        }
        ListNode cur = reverse(head.next);
        //交换前后节点
        head.next.next = head;
        head.next = null;
        return  cur;
    }
}
