package com.lab.silent.algorithm.solution;

import java.util.Arrays;
import java.util.Comparator;

public class 最大数_leetCode_179 {
    /**
     * 核心思路:
     *    对各个数组元素进行字符串排序(字符串排序是会根据字符串字符拉平并排序的)
     */
    public static String largestNumber(int[] nums) {
        //将数字转化为字符串
        String[] arr = new String[nums.length];
        for(int i = 0 ; i< nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        //对字符串进行排序,
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                String ab = a + b;
                String ba = b + a;
                //因为是倒序排列,所以是 ba compare ab;
                return ba.compareTo(ab);
            }
        });
        //排除特殊情况
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {30,32,89,12,23,0};
        String ss = largestNumber(arr);
        System.out.println(ss);
    }
}
