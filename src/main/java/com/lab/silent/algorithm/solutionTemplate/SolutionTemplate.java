package com.lab.silent.algorithm.solutionTemplate;

import com.lab.silent.algorithm.structure.ListNode;
import com.lab.silent.algorithm.structure.Queue;
import com.lab.silent.algorithm.structure.Stack;
import com.lab.silent.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gouqi
 * @version 1.0
 * @description: 算法模板
 * @date 2023/10/11 10:48
 */
public class SolutionTemplate {
    //某种条件
    private final static Boolean CONDITION  = true;


    /**
     * 1.双指针: 只有一个输入,从两端开始遍历
     * @param arr
     * @return
     */
    public int fn1(int[] arr){
        int left = 0;
        int right = arr.length;
        int ans = 0;
        while (left<right){
         //根据题意补充
         if(CONDITION){
             left++;
         }else{
             right--;
         }

        }
        return ans;
    }

    /**
     * 2.双指针: 有两个输入,两个都需要遍历完
     * @param arr1
     * @param arr2
     * @return
     */
    public int fn2(int[] arr1,int[] arr2){
        int i = 0,j = 0,ans = 0 ;
        while (i < arr1.length && j < arr2.length){
            //根据题意补充
            if(CONDITION){
                i++;
            }else{
                j++;
            }
        }
        while (i < arr1.length){
            //根据题意补充
            i++;
        }
        while (j < arr2.length){
            //根据题意补充
            j++;
        }
        return ans;
    }

    /**
     * 3.滑动窗口
     * @param arr
     * @return
     */
    public int fn3(int[] arr){
        int left = 0 , curr = 0, ans = 0;

        for(int right = 0; right < arr.length ;right++){
            //根据题意补充代码将 arr[right] 添加到 curr
            while (CONDITION){
                //从 curr 中删除 arr[left]
                left++;
            }
        }
        return ans;
    }


    /**
     * 4.构建前缀和
     * @param arr
     * @return
     */
    public int[] fn4(int[] arr){
        int[] prefix = new int[]{arr.length};
        prefix[0] = arr[0];

        for (int i = 1;i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    /**
     * 5.构建字符串
     * @param arr
     * @return
     */
    public String fn5(char[] arr){
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 6.链表: 快慢指针
     * @param head
     * @return
     */
    public int fn6(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int ans = 0;
        while (fast != null && fast.next != null){
            //根据题意补充
            slow = slow.next;
            fast = fast.next.next;
        }
        return ans;
    }

    /**
     * 7. 反转链表
     * @return
     */
    public ListNode fn7(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 8.找到符合确切条件的子数组数
     * @param arr
     * @param k
     * @return
     */
    public int fn8(int[] arr,int k){
        Map<Integer,Integer> counts = new HashMap<>();
        counts.put(0,1);
        int ans = 0 ,curr = 0;
        for (int num : arr) {
            //根据题意补充代码来改变 curr
            ans += counts.getOrDefault(curr-k,0);
            counts.put(curr,counts.getOrDefault(curr,0)+1);
        }
        return ans;
    }

    /**
     * 9.单调递增栈
     * @param arr
     * @return
     */
    public int fin9(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int num : arr) {
            //对于单调递减的情况,只需 将 > 翻转到 <
            while(!stack.empty() && stack.peek() > num){
                //根据题意补充代码
                stack.pop();
            }
            stack.push(num);
        }
        return ans;
    }

    /**
     * 10.二叉树: DFS(深度搜索-递归)
     * @param root
     * @return
     */
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        //根据题意补充代码
        dfs(root.left);
        dfs(root.right);
        return ans;
    }

    /**
     * 11.二叉树: DFS(深度搜索-迭代)
     * @param root
     * @return
     */
    public int dfs2(TreeNode root){
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();
            //根据题意补充代码
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return ans;
    }

    /**
     * 12.二叉树: BFS(广度搜索)
     * @param root
     * @return
     */
    public int bfs(TreeNode root){
        int ans = 0;
        Queue<TreeNode> queue = new Queue<>();
        queue.add(root);
        while (!queue.empty()){
            int currentLength = queue.size();
            //做一些当前层的操作
            for(int i = 0; i < currentLength; i++){
                TreeNode node = queue.poll();
                //根据题意补充代码
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }


    private final static  Set<Integer> seen = new HashSet<>();
    private final static  int START_NODE = 0;

    /**
     * 图: DFS(深度搜索-递归)
     *  假设节点编号从 0 到 n-1,并且图是以邻接表的形式
     *
     * @param graph
     * @return
     */
    public int fin10(int[][] graph){
        seen.add(START_NODE);
        return dfsGraph(START_NODE,graph);
    }

    private int dfsGraph(int node, int[][] graph){
        int ans = 0;
        //根据题意补充代码
        for(int neighbor : graph[node]){
            if(!seen.contains(neighbor)){
                seen.add(neighbor);
                ans += dfsGraph(neighbor,graph);
            }
        }
        return ans;
    }

    /**
     * 14.图: DFS(深度搜索-迭代)
     * @param graph
     * @return
     */
    public int fin11(int[][] graph){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(START_NODE);
        seen.add(START_NODE);

        int ans = 0;

        while (!stack.empty()){
            int node = stack.pop();
            //根据题意补充代码
            for(int neighbor : graph[node]){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return ans;
    }

    /**
     * 15.图: BFS
     * @param graph
     * @return
     */
    public int fin12(int[][] graph){
        int ans = 0;
        Queue<Integer> queue = new Queue<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(START_NODE);
        seen.add(START_NODE);

        while (!queue.empty()){
            int node = queue.poll();
            //根据题意补充代码
            for(int neighbor:graph[node]){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return ans;
    }
    public static int lengthOfLongestSubstring(String s) {
        //记录各个字符位置
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        int ans = 0;
        for(int right = 0;right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                //左窗口右移到对应字符位置
                left = Math.max(left,map.get(c));
            }
            map.put(c,right);
            ans = Math.max(ans,map.getOrDefault(c,0) - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcdfgggj";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }





}
