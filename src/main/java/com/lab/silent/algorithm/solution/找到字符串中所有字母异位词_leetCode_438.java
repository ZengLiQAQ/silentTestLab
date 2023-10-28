package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class 找到字符串中所有字母异位词_leetCode_438 {


    /**
     *  核心思路:
     *      1.将p字符串按unionCode排序 - unionKey
     *      2.依次将 i 到   i + p.length -1 的字符串 也按unionCode排序是之后,是否与  unionKey 一致
     *      3.如果 与 unionKey 一致,说明存在字母异位词,则记录对应 i 位置即可
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        //特殊条件
        if(s == null || p == null || p.length() > s.length()){
            return new ArrayList<>();
        }
        List<Integer> ans =  new ArrayList<>();
        char[] targetCharArr = p.toCharArray();
        Arrays.sort(targetCharArr);
        //按 unionCode 排序之后的key
        String unionKey = new String(targetCharArr);

        //当前遍历的索引
        int i = 0;
        //遍历到  s.length()-p.length() 即可
        while (i <= s.length()-p.length()){
            //检查 i 到 i + p.lenth 的位置是否均包含在set中
            String sonStr = s.substring(i,i+p.length());
            //计算按 unionCode 排序之后的当前key
            char[] tmpCharArr = sonStr.toCharArray();
            Arrays.sort(tmpCharArr);
            //按 unionCode 排序之后的key
            String tmpKey = new String(tmpCharArr);
            //key相同即为字母异位词
            if(tmpKey.equals(unionKey)){
                ans.add(i);
            }
            //指针移动一位
            i++;
        }
        return  ans;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer>  result = findAnagrams(s,p);
        System.out.println(JSONObject.toJSONString(result));
    }
}
