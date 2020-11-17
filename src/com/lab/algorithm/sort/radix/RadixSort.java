package com.lab.algorithm.sort.radix;/**
 * Created by zengli on 2020/11/17.
 */

import com.lab.algorithm.sort.bucket.BucketSort;

import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Description 基数排序
 * @Author ZengLi
 * @Date 2020/11/17 14:29
 * @VerSion 1.0
 **/
public class RadixSort {

    public static int[] radixSort(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容
        arr = Arrays.copyOf(arr, arr.length);
        //获取最高位数
        int maxDigit = getMaxDigit(arr);

        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            //考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = BucketSort.arrAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    /**
     * 获取最高位数
     */
    public static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
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

    public static int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int len = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            len++;
        }
        return len;
    }


    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 7, 1, 8, 3, 6};
        System.out.println(Arrays.toString(arr));
        arr = radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
