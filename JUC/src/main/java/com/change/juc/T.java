package com.change.juc;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qiaodong
 * @Date: 2020/6/22 20:20
 */
public class T {
    public static void main(String[] args) {
        String a1 = "1000000000";
        String a2 = "1000000000";
        String a3 = new String("1000000000");
        System.out.println(a1==a2);
        System.out.println(a2==a3);

        AtomicInteger a = new AtomicInteger();
        a.incrementAndGet();

        //ConcurrentHashMap

    }
}
