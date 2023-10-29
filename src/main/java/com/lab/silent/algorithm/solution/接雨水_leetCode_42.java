package com.lab.silent.algorithm.solution;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class 接雨水_leetCode_42 {


    /**
     * 双指针解法:
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        int ans = 0;
        //定义左右指针
        int left = 0,right = height.length-1;
        //定义洼地的左右最大高度
        int leftMax = 0,rightMax = 0;
        while (left < right){
            //每次取最大的高度
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            //如果左边的高度低于右边的高度,则用左边界最高值 减去当前位置的值
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                //移动左指针
                ++left;
            } else {
                ans += rightMax - height[right];
                //移动右指针
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int a = trap(height);
        System.out.println(a);
    }
}
