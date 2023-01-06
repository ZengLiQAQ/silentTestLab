package com.lab.silent.algorithm.sort.heap;/**
 * Created by zengli on 2020/11/17.
 */

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * @Author ZengLi
 * @Date 2020/11/17 12:01
 * @VerSion 1.0
 **/
public class HeapSort {
    public static int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    public static  void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static  void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    public static  void swap(int[] arr, int i, int j) {
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
