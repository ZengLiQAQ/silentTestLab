package com.lab.silent.algorithm.solution;


import java.util.HashMap;
import java.util.Map;

/**
 * @author gouqi
 * @version 1.0
 * @description:
 * @date 2023/9/26 14:34
 */
public class LCRSolution016 {

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
        int s = LCRSolution016.lengthOfLongestStr(str);
        System.out.println(s);
    }
}
