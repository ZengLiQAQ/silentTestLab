package com.lab.silent.algorithm.solution;

public class 最长回文子串_leetCode5 {

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static  String longestPalindrome2(String s){
        //边界条件
        if(s == null || s.length() < 1){
            return "";
        }
        //临时记录回文子串的左右索引
        int start = 0,end = 0;
        for(int i = 0;i<s.length(); i++){
            //场景1,奇数扩散
            int len1 = expandAroundCenter2(s,i,i);
            //场景2,偶数扩散
            int len2 = expandAroundCenter2(s,i,i+1);
            //取最大的长度
            int maxLen = Math.max(len1,len2);
            //比较并替换最大长度下的回文串左右边界
            if(maxLen > (end-start)){
                start = i - (maxLen-1) /2;
                end = i+ maxLen / 2;
            }

        }
        //截取最终字符串
        return s.substring(start,end+1);

    }

    /**
     * 中心扩散
     * @return
     */
    public static int expandAroundCenter2(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return  right - left + 1;
    }

    public static void main(String[] args) {
        String s = "asdfggfdsj";
        String r = longestPalindrome(s);
        System.out.println(r);
        String s2 = "asdfgfdsj";
        String r2 = longestPalindrome(s2);
        System.out.println(r2);
    }
}
