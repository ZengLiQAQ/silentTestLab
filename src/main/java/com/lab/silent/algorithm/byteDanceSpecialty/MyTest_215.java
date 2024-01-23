package com.lab.silent.algorithm.byteDanceSpecialty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author gouqi
 * @version 1.0
 * @description: 超高出现频率题
 * 数组中的第K个最大元素(简单的方式是利用Arrays.sort()方法，然后取第k个元素，时间复杂度为O(nlogn)，空间复杂度为O(1))
 * 实际考察的是快速排序的思想及手写快速排序
 * @date 2024/1/10 23:37
 */
public class MyTest_215 {
    /**
     * 题目：
     * 给定一个整数数组，找到它的第k个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }


    /**
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int index = partition(nums, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
            index = partition(nums, left, right);
        }
        return nums[k - 1];
    }


    /**
     * 对数组进行分区操作，返回pivot的位置
     * 该接口主要目的是对数组中的元素进行重排，使得在指定范围内的所有元素都满足以下条件：
     *      所有小于pivot（数组中left位置的值）的元素都在pivot的左侧；
     *      所有大于等于pivot的元素都在pivot的右侧。
     *
     * 实现概述:
     * 1.将pivot设置为数组中left位置的值。
     *  使用两个循环遍历数组：
     *      外层循环：用while (left < right)确保在左右指针相遇之前继续执行循环。
     *      内层循环（右指针部分）：用while (left < right && nums[right] >= pivot)找到第一个小于pivot的元素，并将右指针向左移动一位。当找不到这样的元素时，跳出内层循环。
     *      内层循环（左指针部分）：用while (left < right && nums[left] <= pivot)找到第一个大于pivot的元素，并将左指针向右移动一位。当找不到这样的元素时，跳出内层循环。
     *      在内外层循环结束后，交换左右指针指向的元素（即nums[left]与nums[right]），使它们位于正确的位置上。
     *      重复步骤2和3，直到左右指针相遇。
     *      最后，将pivot值放在正确的位置（即left指针所在的位置），并返回left作为结果。
     *
     * @param nums  待分区的整数数组
     * @param left  分区起始位置
     * @param right 分区结束位置
     * @return 返回pivot元素所在的位置
     */
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            // 从右向左找到第一个小于pivot的元素，将其移到左侧
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];

            // 从左向右找到第一个大于等于pivot的元素，将其移到右侧
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


    /**
     * 利用 Arrays.sort()方法辅助实现
     *  因为他需要对整个数组进行排序,时间复杂度为O(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }
        //将nums排序
        Arrays.sort(nums);
        return  nums[nums.length-k];
    }


    /**
     *  利用快速选择加分治的实现方式
     * @param nums
     * @param k
     * @return
     */
        private int quickSelect(List<Integer> nums, int k) {
            // 随机选择基准数
            int pivot = nums.get(new Random().nextInt(nums.size()));
            // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
            List<Integer> big = new ArrayList<>(),equal = new ArrayList<>(),small = new ArrayList<>();
            //根据大小划分大中小三种不同的数据范围的数据分组中
            for (int num : nums) {
                if (num > pivot)
                    big.add(num);
                else if (num < pivot)
                    small.add(num);
                else
                    equal.add(num);
            }
            // 第 k 大元素在 big 中，递归划分
            if (k <= big.size())
                return quickSelect(big, k);
            // 第 k 大元素在 small 中，递归划分,只需要用k-big的size即可
            if (nums.size() - small.size() < k)
                return quickSelect(small, k - nums.size() + small.size());
            // 第 k 大元素在 equal 中，直接返回 pivot
            return pivot;
        }

        public int findKthLargest3(int[] nums, int k) {
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }
            return quickSelect(numList, k);
        }

}
