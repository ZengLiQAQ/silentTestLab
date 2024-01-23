package com.lab.silent.algorithm.byteDanceSpecialty;

public class 手写快排_练习2 {
    /**
     * 利用快排的方式实现
     */
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length -1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        //找到当前子数组的基准值索引
        int p = partition(nums,left,right);
        //排序左边的子数组
        quickSort(nums,left,p-1);
        //排序右边的子数组
        quickSort(nums,p+1,right);
    }
    /**
     * 基准值划分
     */
    public int partition(int[] nums,int left,int right){
        //i为左指针,j为右指针,默认以left位置的值作为基准值
        int i = left, j = right;
        while(i<j){
            //从右往左找小于基准值的元素,如果右边的元素只要大于基准值就左移,否则就停止
            while(i<j && nums[j]>=nums[left]){j--;}
            //从左往右找大于基准值的元素,如果左边的元素只要小于基准值就右移,否则就停止
            while(j<j && nums[i]<=nums[left]) {i++;}
            //交换两个值得位置,以保证打的再右边,小的的左边
            swap(nums,i,j);
        }
        //最终将当前的基准值设置到两个子数组的分界线上
        swap(nums,i,left);
        return i;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
