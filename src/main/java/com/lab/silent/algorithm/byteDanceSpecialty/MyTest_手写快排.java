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
        if(left >= right) return;
        //找到当前子数组的基准值
        int p = partition(arr, left, right);
        //排序左边的数组
        quickSort(arr, left, p - 1);
        //排序右边的数组
        quickSort(arr, p + 1, right);
    }

    /**
     * 基准值划分
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr,int left, int right){
        int i = left,j = right;
        while (i<j){
            //从右往左找小于基准值的元素
            while (i<j && arr[j]>=arr[left]) j--;
            //从左右大于基准值的元素
            while (i<j && arr[i] <= arr[left]) i++;
            //交换元素
            swap(arr,i,j);
        }
        //交换基准值到两个子数组的分界线
        swap(arr,i,left);
        return i;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }







}
