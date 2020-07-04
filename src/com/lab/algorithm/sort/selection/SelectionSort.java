package com.lab.algorithm.sort.selection;/**
 * Created by zengli on 2020/7/4.
 */

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName SelectionSort
 * @Description 选择排序
 * @Author ZengLi
 * @Date 2020/7/4 12:13
 * @VerSion 1.0
 **/
public class SelectionSort {

    /**
     * 选择排序
     * @param array
     */
    public static void selectionSort(int[] array){
        int minIndex,temp;
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 寻找最小的数
                if (array[j] < array[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


    public static void main(String[] args) {
        //测试数组
        int[] array = new int[]{6,1,2,4,3,9,7,5,12,8};
        System.out.println(JSONObject.toJSONString(array));
        selectionSort(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
