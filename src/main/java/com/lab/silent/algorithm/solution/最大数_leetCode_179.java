package com.lab.silent.algorithm.solution;

import java.util.Arrays;
import java.util.Comparator;

public class 最大数_leetCode_179 {
    /**
     * 核心思路:
     *    对各个数组元素进行字符串排序(字符串排序是会根据字符串字符最左侧优先排序的)
     * 需要储备知识:对于string类型的字符串对比的实现是什么?
     String 类的 compareTo实现
     public int compareTo(String anotherString) {
     //当前字符长度
     int len1 = value.length;
     //需要对比的字符长度
     int len2 = anotherString.value.length;
     //取最小的字符长度
     int lim = Math.min(len1, len2);
     //获取双放的char数组
     char v1[] = value;
     char v2[] = anotherString.value;

     int k = 0;
     //按照最小的字符串长度去对比unicode值的大小
     while (k < lim) {
     char c1 = v1[k];
     char c2 = v2[k];
     //按字符数组从左往右只要有字符不相等,则返回对比结果:实际为 unicode 的值,char:两个字节,2^16 = 65536个字符,这里的c1-c2实际就是对比的当前字符在unicode字典表的索引位子差值
     if (c1 != c2) {
     return c1 - c2;
     }
     k++;
     }
     //如果长的字符串完全包含小的字符串,则直接对比字符数组长度差值
     return len1 - len2;
     }
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
