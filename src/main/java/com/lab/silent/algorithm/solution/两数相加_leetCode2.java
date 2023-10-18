package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/18.
 */

import com.alibaba.fastjson.JSONObject;
import com.lab.silent.algorithm.structure.ListNode;

/**
 * @ClassName 两数相加
 * @Description 题目描述:
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 465 = 807
 *
 * @Author ZengLi
 * @Date 2020/11/18 16:01
 * @VerSion 1.0
 **/
public class 两数相加_leetCode2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个新的链表，pre是其虚拟头节点
        ListNode pre = new ListNode(0);
        // 创建一个指针cur，指向当前处理的节点
        ListNode cur = pre;
        // carry表示进位
        int carry = 0;
        // 当l1或l2不为空时，进入循环
        while(l1 != null || l2 != null) {
            // 如果l1不为空，取l1的值，否则取0
            int x = l1 == null ? 0 : l1.val;
            // 如果l2不为空，取l2的值，否则取0
            int y = l2 == null ? 0 : l2.val;
            // 计算当前位的和
            int sum = x + y + carry;
            // 更新进位
            carry = sum / 10;
            // 计算当前位的值
            sum = sum % 10;
            // 创建一个新的节点，值为sum，然后将cur的next指向这个新节点
            cur.next = new ListNode(sum);
            // 将cur向后移动一位
            cur = cur.next;
            // 如果l1不为空，将l1向后移动一位
            if(l1 != null) {
                l1 = l1.next;
            }
            // 如果l2不为空，将l2向后移动一位
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后还有进位
        if(carry == 1) {
            // 创建一个新的节点，值为carry，然后将cur的next指向这个新节点
            cur.next = new ListNode(carry);
        }
        // 返回结果链表的头节点
        return pre.next;
    }


    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(null));
        System.out.println(JSONObject.toJSONString(null));
    }
}
