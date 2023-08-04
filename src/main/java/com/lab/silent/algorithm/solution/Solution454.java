package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution454
 * @Description 四数相加 II
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过231 - 1 。
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @Author ZengLi
 * @Date 2020/11/27 16:43
 * @VerSion 1.0
 **/
public class Solution454 {

    /**
     * 题目分析:
     * 1. 四个数组长度一致
     * 2. 每个数组取一个数据,最终的结果相加,结果为0
     * 暴力法:
     * 4层循环,结果相加等于0,则result加1
     * 主要思路: 分治,哈希
     * 1.双重循环,将A,B 与  C,D 分别统计起来,最终再通过hash的方式来计算
     * 申明两个map,
     * ① : map1: key: A[i] + B[j] 的结果: value: 组成当前结果,在A,B中共有多少种
     * ② : map2: key: C[k] + D[l] 的结果: value: 组成当前结果,在C,D中共有多少种
     * 最终再去判断map1中的哪些key+map2中的哪些key的结果为0,
     * 取出两个map中的vaule,相乘之后,便是最终的不同的结果
     * 结果: 超时
     * 优化1:
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        //最终组合方案数量
        int result = 0;
        //AB组合
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int key = i + j;
                Integer count = map1.get(key);
                if (count == null) {
                    count = 0;
                }
                count++;
                map1.put(key, count);
            }
        }
        //CD组合
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : C) {
            for (int j : D) {
                int key = i + j;
                Integer count = map2.get(key);
                if (count == null) {
                    count = 0;
                }
                count++;
                map2.put(key, count);
            }
        }
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            int key1 = entry1.getKey();
            int value1 = entry1.getValue();
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                int key2 = entry2.getKey();
                int value2 = entry2.getValue();
                if (key1 + key2 == 0) {
                    result += (value1 * value2);
                }
            }
        }
        return result;

    }

    /**
     * 优化:
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int a:A) {
            for(int b:B) {
                map.merge(a+b, 1, (v1,v2)->v1+1);
            }
        }
        int result=0;
        for(int c:C) {
            for(int d:D) {
                result+=map.getOrDefault(0-c-d, 0);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Solution454 solution = new Solution454();
        int[] A = {-1, 1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {-1, 1};
        int result = solution.fourSumCount1(A, B, C, D);
        int result2 = solution.fourSumCount2(A, B, C, D);

        System.out.println(result);
        System.out.println(result2);
    }
}
