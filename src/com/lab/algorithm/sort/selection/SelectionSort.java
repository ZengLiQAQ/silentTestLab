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

    }


    public static void main(String[] args) {
        //测试数组
        int[] array = new int[]{1,2,4,6,3,7,5,12,9,8};
        System.out.println(JSONObject.toJSONString(array));
        selectionSort(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
