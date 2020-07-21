package com.change.juc.training;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qiaodong
 * @Date: 2020/6/28 20:30
 */
public class T_03 {

    synchronized void m1 () {
        int i = 1/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 方法执行完毕了");
    }

    synchronized void m2() {
        System.out.println("m2 方法执行完毕了");
    }

    public static void main(String[] args) {
        T_03 t3 = new T_03();

        new Thread(t3::m1,"t1").start();
        new Thread(t3::m2,"t2").start();
    }

}
