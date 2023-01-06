package com.lab.silent.algorithm.sort.insertion;/**
 * Created by zengli on 2020/7/4.
 */

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName InsertionSort
 * @Description 插入排序
 * @Author ZengLi
 * @Date 2020/7/4 16:59
 * @VerSion 1.0
 **/
public class InsertionSort {

    public static int[] insertionSort(int[] array){
        int len = array.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = array[i];
            while(preIndex >= 0 && array[preIndex] > current) {
                //依次对比排序,如果比当前值大,则将该元素往后移动一位,为要排序的值让出位置
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }


    public static void main(String[] args) {
        //测试数组
        int[] array = new int[]{6,1,2,4,3,9,7,5,12,8};
        System.out.println(JSONObject.toJSONString(array));
        insertionSort(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
