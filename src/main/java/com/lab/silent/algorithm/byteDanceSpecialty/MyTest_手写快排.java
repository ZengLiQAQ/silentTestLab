package com.lab.silent.algorithm.byteDanceSpecialty;

/**
 * @author gouqi
 * @version 1.0
 * @description: 快排复杂度为O(nlogn)
 * @date 2024/1/16 10:50
 */
public class MyTest_手写快排 {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 7, 1, 8, 3, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 快排
     * @param arr 待排序的数组
     * @param left 左指针
     * @param right 右指针
     */
    public static void  quickSort(int[] arr,int left, int right){
        if(left < right){
            //找到当前子数组的基准值
            int partitionIndex = partition(arr, left, right);
            //排序左边的数组
            quickSort(arr, left, partitionIndex - 1);
            //排序右边的数组
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    public static int partition(int[] arr,int left, int right){
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

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }







}
