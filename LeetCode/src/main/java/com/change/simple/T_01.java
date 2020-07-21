/*
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 请返回 nums 的动态和。
 * 示例:
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
 */
package com.change.simple;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: qiaodong
 * @Date: 2020/7/6 22:33
 */
public class T_01 {

    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        int[] ret = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            ret[i] = sum(i,nums);
        }

        System.out.println(Arrays.toString(ret));

    }

    public static int sum(int i,int[] nums){
        ++i;
        int sum =0 ;
        while(i>0) {
            sum += nums[i-1];
            i--;
        }
        return sum;
    }

}
