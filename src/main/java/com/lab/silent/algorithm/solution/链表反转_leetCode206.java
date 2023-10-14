package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/26.
 */

import com.alibaba.fastjson.JSONObject;
import com.lab.silent.algorithm.structure.ListNode;

/**
 * @ClassName Solution206
 * @Description 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Author ZengLi
 * @Date 2020/11/26 17:37
 * @VerSion 1.0
 **/
public class 链表反转_leetCode206 {

    /**
     * 迭代(双指针):
     * 遍历链表: 将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点
     * 因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     * 时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        //当前节点的前面一个元素(头结点前一个元素为null)
        ListNode prev = null;
        //迭代的当前元素
        ListNode curr = head;
        while (curr != null){
            //获取当前节点的下一个节点
            ListNode nextTmp = curr.next;
            //将指针指向前一个元素
            curr.next = prev;
            //将当前元素置为下一个元素的前一个元素
            prev = curr;
            //将下一个节点设置为当前节点
            curr = nextTmp;
        }
        return prev;
    }

    /**
     * 递归方式:
     * 递归的意思：我子节点下的所有节点都已经反转好了，
     * 现在就剩我和我的子节点 没有完成最后的反转了，
     * 所以反转一下我和我的子节点。
     *
     * 假设链表是[1, 2, 3, 4, 5]从最底层最后一个reverseList(5)来看
     * 返回了5这个节点
     * reverseList(4)中
     * p为5
     * head.next.next = head 相当于 5 -> 4
     * 现在节点情况为 4 -> 5 -> 4
     * head.next = null,切断4 -> 5 这一条，现在只有 5 -> 4
     * 返回（return）p为5，5 -> 4
     * 返回上一层reverseList(3)
     * 处理完后返回的是4 -> 3
     * 依次向上
     *
     * 自己的理解:
     * 假设: (1->2)-(2->3)-(3->4)-(4->5)-(5-null)
     * 递归情况下直接到最后一个节点:(5->null)
     *   反转之后是:节点5指向节点4, (5 -> 4) ,但是实际节点4又指向的5,所以,必须将节点4的next 设置位null(避免循环链表)
     *   依次向上:
     *   0. (1->2)-(2->3)-(3->4)-(4->5)-(5-null)
     *   1. (1->2)-(2->3)-(3->4)-(4->null)-(5-4)
     *   2. (1->2)-(2->3)-(3->null)-(4->3)-(5-4)
     *   3. (1->2)-(2->null)-(3->4)-(4->5)-(5-4)
     *   4. (1->null)-(2->3)-(3->4)-(4->5)-(5-4)
     *   5. 递归完成返回
     *   一眼就能看出,这里其实就是单向链表的末尾的next元素,不停的与前一个元素的val替换的过程
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for(int i = 2 ; i< 4 ; i++){
            ListNode next = new ListNode(i);
            curr.next = next;
            curr = next;
        }
        System.out.println(JSONObject.toJSONString(head));
        //迭代
        ListNode result = reverseList1(head);

        System.out.println(JSONObject.toJSONString(result));
        //递归
        ListNode result2 = reverseList2(result);

        System.out.println(JSONObject.toJSONString(result2));


    }
}
