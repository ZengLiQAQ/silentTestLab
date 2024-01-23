package com.lab.silent.algorithm.byteDanceSpecialty;

public class MyTest_手写堆排序 {
    /* 堆的长度为 n ，从节点 i 开始，从顶至底堆化 */
    void heapify(int[] nums, int n, int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 m
            //左子树索引
            int l = 2 * i + 1;
            //右子树索引
            int r = 2 * i + 2;
            int m = i;
            if (l < n && nums[l] > nums[m])
                m = l;
            if (r < n && nums[r] > nums[m])
                m = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (m == i)
                break;
            // 交换两节点
            int temp = nums[i];
            nums[i] = nums[m];
            nums[m] = temp;
            // 循环向下堆化
            i = m;
        }
    }

    /* 堆排序 */
    void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换根节点与最右叶节点（交换首元素与尾元素）
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            // 以根节点为起点，从顶至底进行堆化
            heapify(nums, i, 0);
        }
    }
}
