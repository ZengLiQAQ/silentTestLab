package com.lab.silent.algorithm.solution;

public class 整数反转_leetCode7 {
    /**
     * 整数反转:
     * -2^31 <= x <= 2^31 - 1
     * 核心思路: 除以10取余,返回结果*10扩大即可,注意反转之后数字不能超过int范围
     *   最大值: 2147483647 则反转钱的值是:
     *   最小值: 2147483648
     *   12345 -> 54321
     * @param x
     * @return
     */
    public static int reverse(int x){
        int ans = 0;
        while(x != 0){
            //边界条件: 反转之后的最大值
            if(ans < Integer.MIN_VALUE/10 || ans > Integer.MAX_VALUE/10){
                return 0;
            }
            int r = x % 10;
            //原数每次处理完之后缩小一位
            x /= 10;
            ans = ans * 10 + r;
        }
        return ans;
    }

    /**
     * 字符串方式
     * @param x
     * @return
     */
    public static int reverse2(int x){
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        if(x<0){
            sb.append("-");
        }
        try {
            return Integer.parseInt(sb.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 12345;
        int r = reverse(x);
        System.out.println(r);
    }
}
