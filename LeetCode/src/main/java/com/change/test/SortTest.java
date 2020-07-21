package com.change.test;

import java.util.Arrays;

/**
 * @Author: qiaodong
 * @Date: 2020/7/15 19:59
 */
public class SortTest {

    public static void main(String[] args) {

        //int arr[] = {8, 5, 3, 2, 4};
        //int arr[] = {10,8,6,5,3,2,0};
        int arr[] = {7, 5, 3, 2, 4, 1, 8, 9, 6};

        //sort1(arr);
        //sort2(arr);
        //sort3(arr);
        sort4(arr);
        //sort5(arr);
    }

    //冒泡
    public static void sort1(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;j<arr.length-i-1;j++ ) {
                if(arr[j]<arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //选择
    public static void sort2(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1;j<arr.length;j++ ) {
                if(arr[i]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    //插入
    public static void sort3(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i;j>0;j-- ) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
            }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    //希尔排序
    public static void sort4(int arr[]) {

        //希尔排序（插入排序变种版）
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //i层循环控制步长
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
            //j,k为插入排序，不过步长为i
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
    }

    // 快速排序
    public static void sort5(int[] arr) {

        //快速排序
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        //默认中间值为低指针的第一个值
        int midValue = arr[low];
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (arr[high] > midValue) {
                    high--;
                } else if (arr[high] < midValue) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    arr[low] = arr[high];
                    low++;
                    flag = false;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (arr[low] < midValue) {
                    low++;
                } else if (arr[low] > midValue) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    arr[high] = arr[low];
                    high--;
                    flag = true;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (low == high) {
                arr[low] = midValue;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(arr, start, low -1);
        quickSort(arr, low + 1, end);
    }
}
