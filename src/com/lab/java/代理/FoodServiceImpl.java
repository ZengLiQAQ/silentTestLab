package com.lab.java.代理.JDK动态代理;/**
 * Created by zengli on 2021/1/11.
 */

/**
 * @ClassName FoodServiceImpl
 * @Description 实现接口
 * @Author ZengLi
 * @Date 2021/1/11 16:45
 * @VerSion 1.0
 **/
public class FoodServiceImpl implements FoodService {
    @Override
    public void makeNoodle() {
        System.out.println("make noodle");
    }

    @Override
    public void makeChicken() {
        System.out.println("make Chicken");
    }
}