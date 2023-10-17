package com.lab.silent.algorithm.solution;

/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 *
 *
 * 提示：
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class 两数相除_leetCode_29 {

    /**
     * 暴力解法: 除以就是每次减去除数
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide1(int dividend, int divisor) {
        if(divisor == 0){
            throw  new IllegalArgumentException("除数不能为0");
        }
        if(dividend == 0){
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long ans = 0;
        while(dividendLong >= divisorLong){
            dividendLong -= divisorLong;
            ans++;
        }
        //符号相同:同正同负
        if((dividend > 0 && divisor > 0)  || (dividend < 0 && divisor < 0)){
            return ans > max ? max : (int)ans;
        }else{
            return -ans < min ? min : (int)-ans;
        }
    }


    /**
     * 二分法: 除以就是每次减去除数(逐渐增加每次减的除数的值来尽可能扩大步长)
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if(divisor == 0){
            throw  new IllegalArgumentException("除数不能为0");
        }
        if(dividend == 0){
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long ans = 0;
        while(dividendLong >= divisorLong){
            //默认步长倍数为1
            long a = 1;
            //默认步长数为除数本身
            long tmp = divisorLong;
            //如果被除数比步长大,则扩大步长
            while (dividendLong >= tmp){
                dividendLong -= tmp;
                //暴力解法为每次+1,这里逐步增加步长的方式为每次+步长扩大的倍数
                ans += a;
                //无符号左移一位即: a = a * 2
                a = a << 1;
                //步长每次扩大一倍
                tmp = tmp << 1;
            }
        }
        //符号相同:同正同负
        if((dividend > 0 && divisor > 0)  || (dividend < 0 && divisor < 0)){
            return ans > max ? max : (int)ans;
        }else{
            return -ans < min ? min : (int)-ans;
        }
    }

    public static void main(String[] args) {
        int s = divide1(-2147483648,-1);
        System.out.println(s);
    }


}
