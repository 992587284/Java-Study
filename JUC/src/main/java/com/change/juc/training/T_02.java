package com.change.juc.training;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qiaodong
 * @Date: 2020/6/28 20:30
 */
public class T_02 {

    synchronized void m1 () {
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
        T_02 t2 = new T_02();

        new Thread(t2::m1,"t1").start();
        new Thread(t2::m2,"t2").start();
    }

}
