package com.lab.algorithm.sort.counting;/**
 * Created by zengli on 2020/11/17.
 */

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Description 计数排序
 * @Author ZengLi
 * @Date 2020/11/17 13:49
 * @VerSion 1.0
 **/
public class CountingSort {


    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    public static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    public static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 7, 1, 8, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
