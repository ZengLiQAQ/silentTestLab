package com.lab.algorithm.sort.bucket;/**
 * Created by zengli on 2020/11/17.
 */

import com.lab.algorithm.sort.insertion.InsertionSort;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName BucketSort
 * @Description 桶排序
 * @Author ZengLi
 * @Date 2020/11/17 13:54
 * @VerSion 1.0
 **/
public class BucketSort {

    public static int[] bucketSort(int[] arr, Integer bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        //获取最小值
        int minValue = arr[0];
        //获取最大值
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                // 输入数据的最小值
                minValue = value;
            } else if (value > maxValue) {
                // 输入数据的最大值
                maxValue = value;
            }
        }
        //桶的初始化
        // 设置桶的默认容量为5
        int DEFAULT_BUCKET_SIZE = 5;
        bucketSize = Optional.ofNullable(bucketSize).orElse(DEFAULT_BUCKET_SIZE);
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        //利用映射函数将数据分配到各个桶中
        for (int value : arr) {
            int index = (int) Math.floor((value - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], value);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            // 对每个桶进行排序，这里使用了插入排序
            bucket = InsertionSort.insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    public static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 7, 1, 8, 3, 6};
        System.out.println(Arrays.toString(arr));
        arr = bucketSort(arr, null);
        System.out.println(Arrays.toString(arr));
    }

}
