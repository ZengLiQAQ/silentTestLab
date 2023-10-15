package com.lab.silent.algorithm.solution;

public class 二分查找_leetCode704 {

    /**
     * 二分查找本质上可以理解为双指针组成的窗口,通过不断判断mid位置的值与target的大小来不断缩小窗口的过程
     * @param nums
     * @param target
     * @return
     */
   public  static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int a = search(arr,12);
        System.out.println(a);
    }


}
