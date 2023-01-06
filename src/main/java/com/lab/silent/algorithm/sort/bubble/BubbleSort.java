package com.lab.silent.algorithm.sort.bubble;
/**
 * Created by zengli on 2020/7/3.
 */

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author ZengLi
 * @Date 2020/7/3 10:50
 * @VerSion 1.0
 **/
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param array 数组
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                // 相邻元素两两对比
                if (array[j] > array[j + 1]) {
                    // 元素交换
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //测试数组
        int[] array = new int[]{1,2,4,6,3,7,5,12,9,8};
        System.out.println(JSONObject.toJSONString(array));
        bubbleSort(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
