package com.lab.silent.algorithm.sort.quick;/**
 * Created by zengli on 2020/11/17.
 */

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 *          快速排序的核心是分治法:
 *              1. 选择一个基准值(pivot),通常选择第一个元素或者最后一个元素
 *              2. 分区(partition):将数组分成两部分，一部分比基准值小，一部分比基准值大
 *              3. 递归排序子数组
 * @Author ZengLi
 * @Date 2020/11/17 11:21
 * @VerSion 1.0
 **/
public class QuickSort {
    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对数组进行快速排序
     *
     * @param arr   待排序的数组
     * @param left  起始索引
     * @param right 结束索引
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 分区操作
     *
     * @param arr   数组
     * @param left  左边界
     * @param right 右边界
     * @return 返回基准值的最终位置
     */
    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr   数组
     * @param i     第一个元素的索引
     * @param j     第二个元素的索引
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 7, 1, 8, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
