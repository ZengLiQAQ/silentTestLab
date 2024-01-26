package com.lab.silent.algorithm.solution;

import java.util.Stack;

public class 翻转字符串的单词_leetcode151 {
    //思路: 将字符串的单词入栈,再取出
    public static String reverseWords(String s){
        Stack<String> stack = new Stack<>();
        //单词起始位置
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                stack.add(s.substring(left,i));
                left = i+1;
            }
        }
        stack.add(s.substring(left,s.length()));
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            String str = stack.pop();
            sb.append(str);
            if(!stack.isEmpty() && str != ""){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s ="  test  a  bbb cc  ";
        System.out.println(reverseWords(s));
    }
}
