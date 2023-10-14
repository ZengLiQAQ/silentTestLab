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
    /**
     * 核心:
     * 堆是一个近似完全二叉树的结构，并同时满足堆积的性质：
     *  即子结点的键值或索引总是小于（或者大于）它的父节点。
     * @param sourceArray
     * @return
     */
    public static int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        //构建大顶堆
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            //R(1) 与 无序区最后一个元素进行替换
            swap(arr, 0, i);
            //替换之后的无序区长度减一
            len--;
            //重新堆化无序区
            heapify(arr, 0, len);
        }
        return arr;
    }

    public static  void buildMaxHeap(int[] arr, int len) {
        //i: 当前父节点 idx=
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static  void heapify(int[] arr, int i, int len) {
        //左子节点
        int left = 2 * i + 1;
        //右子节点
        int right = 2 * i + 2;
        //当前父子节点中最大的节点:默认为父节点
        int largest = i;
        //如果存在左节点,且左子节点比父节点的值大,则重置最大的节点idx
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        //如果存在右节点,且右子节点比父节点的值大,则重置最大的节点idx
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        //只要进行了
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
        int[] arrCopy =sort(arr);
        System.out.println(Arrays.toString(arrCopy));
    }
}
