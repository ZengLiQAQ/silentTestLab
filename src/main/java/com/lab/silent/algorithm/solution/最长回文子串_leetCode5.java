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
        return  right - left - 1;
    }

    //中心扩散法计算
    public static  String longestPalindrome3(String s) {
        //子数组临时左右索引位置
        int left = 0; int right = 0;
        //遍历字符,依次计算最长子数组长度
        for(int i = 0 ;i< s.length();i++){
            //奇数回文
            int len1 = ex(s,i,i);
            //偶数回文
            int len2 = ex(s,i,i+1);
            //当前两个场景下最长的子串长度
            int max = Math.max(len1,len2);
            //与之前的最大子串长度对比
            if(max > (right - left)){
                left = i - (max-1)/2;
                right = i + max/2;
            }
        }
        return s.substring(left,right+1);
    }

    //验证指定子数组是否是回文,返回长度
    public static int ex(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        String s = "asdfggfdsj";
        String r = longestPalindrome(s);
        String t = longestPalindrome3(s);
        System.out.println(r);
        System.out.println(t);
        String s2 = "asdfgfdsj";
        String r2 = longestPalindrome(s2);
        String r3 = longestPalindrome3(s2);
        System.out.println(r2);
        System.out.println(r3);
    }
}
