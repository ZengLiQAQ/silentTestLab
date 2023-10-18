package com.lab.silent.algorithm.solution;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


    /**
     * LCR 016. 无重复字符的最长子串
     *  双指针 + map(统计是否重复)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        //定义窗口边界
        int left = 0;
        int right = 0;
        //终止条件为右边界滑动到字符数组末尾
        while (right < s.length()){
            //获取右边界当前的字符
            char c = s.charAt(right);
            //如果存在重复的字符,则说明右边界曾经扫描过该字符串(即上一个不重复子串已经结束,从当前开始需要重新开始结算不重复子串所以这里认为当前子串之前的字符不算重复)
            if(map.containsKey(c) && map.get(c) >=  left){
                left = Math.max(left+1,map.get(c)+1);
            }
            //记录当前子串
            map.put(c,right);
            //当前子串的长度
            ans = Math.max(ans,right-left+1);
            //移动右边界
            right++;
        }
        return ans;
    }




    public static void main(String[] args) {

        String str2 = "tmmzuxt";
        int s2 = 无重复字符的最长子串_leetCode_LCR_016.lengthOfLongestSubstring2(str2);
        System.out.println(s2);
    }
}
