/*
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
package com.change.simple;

import java.util.Arrays;

/**
 * @Author: qiaodong
 * @Date: 2020/7/8 20:24
 */
public class T_03 {

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15},target = 9;
        int ret[] = new int[2];
        for (int i=0;i<nums.length;i++) {

            int temp = target - nums[i];

            for (int j=i+1;j<nums.length;j++) {
                if(temp == nums[j]) {
                    ret[0] = i;
                    ret[1] = j;
                }
            }

        }

        System.out.println(Arrays.toString(ret));

    }

}
