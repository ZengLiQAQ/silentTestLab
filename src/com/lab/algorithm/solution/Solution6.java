package com.lab.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import com.lab.algorithm.structure.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName Solution6
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Author ZengLi
 * @Date 2020/11/27 14:41
 * @VerSion 1.0
 **/
public class Solution6 {
    //1.链表转数组,数组取取反
    public static int[] reversePrint1(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode curr = head;
        int[] arr = new int[1];
        arr[0] = curr.val;
        while (curr.next != null) {
            int length = arr.length;
            int[] tmpArry = Arrays.copyOf(arr, ++length);
            tmpArry[length-1] = curr.next.val;
            curr = curr.next;
            arr = tmpArry;
        }
        int[] result = new int[arr.length];
        int i = 0;
        for (int j = (arr.length - 1); j >=0 ; j--) {
            result[i] = arr[j];
            i++;
        }
        return result;
    }

    //利用栈先进后出的特点
    public static int[] reversePrint2(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 4; i++) {
            ListNode next = new ListNode(i);
            curr.next = next;
            curr = next;
        }

        int[] result = reversePrint1(head);
        System.out.println(result.toString());
    }
}
