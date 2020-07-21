package com.change.juc.training;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: qiaodong
 * @Date: 2020/6/30 20:36
 */
public class T_04 {

    public static void main(String[] args) {
        // 两个线程交替输出 A1B2C3...Z26
        final Object o = new Object();
        Thread t1 = new Thread(()->{
            for(int i=1;i<=26;i++) {
                synchronized (o) {
                    System.out.print(Character.toUpperCase((char) (96 + i)));
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    o.notify();
                    if(i<26) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=1;i<=26;i++) {
                synchronized (o) {

                    System.out.print(i);
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    o.notify();
                    if(i<26) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
