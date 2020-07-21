package com.change.juc;

import sun.misc.ThreadGroupUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiaodong
 * @Date: 2020/6/24 19:48
 */
public class ReentrantLock_01 {

    synchronized void m1() {
        System.out.println(Thread.currentThread().getName()+" start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }

    public static void main(String[] args) {
        ReentrantLock_01 r1 = new ReentrantLock_01();
        new Thread(r1::m1,"t1").start();
        new Thread(r1::m1,"t2").start();

    }

}
