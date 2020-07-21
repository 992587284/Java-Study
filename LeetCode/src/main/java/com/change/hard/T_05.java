/*
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
package com.change.hard;

import java.util.Arrays;

/**
 * @Author: qiaodong
 * @Date: 2020/7/12 01:02
 */
public class T_05 {

    public static void main(String[] args) {
        String s = "aab";
        
        char[] chars = s.toCharArray();
        int length = 0;
        char[] temp = new char[0];
        int long_length = 0;
        for (char c : chars) {
            String str = String.valueOf(temp);
            boolean index = str.contains(String.valueOf(c));
            if(index && temp.length>0) {
                //System.out.println(length);
                if(length > long_length) long_length = length;
                //System.out.println(long_length);
                temp = new char[1];
                temp[0] = c;
                length = 1;
            } else {
                temp = Arrays.copyOf(temp,temp.length+1);
                temp[temp.length-1] = c;
                length++;
            }
        }
        if(length > long_length) long_length = length;
        System.out.println(long_length);
    }
    
}
