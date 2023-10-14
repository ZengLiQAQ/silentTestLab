package com.lab.silent.algorithm.solution;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 */
public class 无重复字符的最长子串_leetCode_LCR_016 {

  private static int lengthOfLongestStr(String s ){
      Map<Character,Integer> map = new HashMap<>();
      int maxLen = 0;
      int left = 0;

      for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if(map.containsKey(c)){
               left = Math.max(left,map.get(c));
           }
           map.put(c,i);
           maxLen = Math.max(maxLen,i-left+1);
      }
      return maxLen;

  }




    public static void main(String[] args) {
        String str = "abcdeef";
        int s = 无重复字符的最长子串_leetCode_LCR_016.lengthOfLongestStr(str);
        System.out.println(s);
    }
}
