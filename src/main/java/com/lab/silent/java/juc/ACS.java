package com.lab.silent.java.juc;/**
 * Created by zengli on 2020/11/24.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ACS
 * @Description acs相关测试类
 * @Author ZengLi
 * @Date 2020/11/24 15:44
 * @VerSion 1.0
 **/
public class ACS {
    public static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.incrementAndGet();
                    System.out.println("Thread One : value:"+atomicInteger.get());
                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.incrementAndGet();
                    System.out.println("Thread Two : value:"+atomicInteger.get());
                }
            }
        });
        one.start();
        two.start();
    }

}
