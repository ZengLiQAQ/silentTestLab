package com.lab.silent.algorithm.solution;

public class 爬楼梯_leetCode_70 {

    /**
     * 递归:爬楼梯
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 递归:爬楼梯,通过cache 记录中间每一次的计算结果
     * @param n
     * @return
     */
    public int climbStairs(int n) {
       int[] cache = new int[n+1];
       return climbStairsCache(n,cache);
    }

    public int climbStairsCache(int n,int[] cache){
        //说明当前已经计算过了
        if(cache[n] > 0){
            return cache[n];
        }
        if(n == 1){
            cache[1] = 1;
        }else if(n == 2){
            cache[2] = 2;
        }else {
            cache[n] = climbStairsCache(n-1,cache) + climbStairsCache(n-2,cache);
        }
        return cache[n];
    }

    /**
     * 方法3: 通过动态规划的方式统计
     */
    public int climbStairs3(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        //每次记录前面统计之和
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }

    /**
     * 通过斐波那契数列(滚动数组的方式计算每次的状态变更)
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int first = 1;
        int sec = 2;
        //每次记录前面统计之和
        for(int i = 3;i <= n;i++){
            int third = first + sec;
            first = sec;
            sec = third;
        }
        return sec;
    }

    /**
     * Binet`s Formula 方式,推到过程不会,别问,问就是硬记的
     * @param n
     * @return
     */
    public int climbStairs5(int n) {
        double sqrt5 = Math.sqrt(5);
        double result = (Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1))/sqrt5;
        return (int) result;
    }

}
