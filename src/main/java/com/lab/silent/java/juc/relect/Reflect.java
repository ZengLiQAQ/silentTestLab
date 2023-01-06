package com.lab.silent.java.juc.relect;/**
 * Created by zengli on 2020/11/24.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName reflect
 * @Description 反射
 * @Author ZengLi
 * @Date 2020/11/24 16:44
 * @VerSion 1.0
 **/
public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        Person p = new Person("老王");
        //三种获取 Class对象的方式
        Class clazzOne = p.getClass();
        Class clazzTwo = Person.class;
        Class clazzThree = Class.forName("com.lab.silent.java.juc.relect.Person");
        //获取Person 类的方法
        Method[] methods = clazzTwo.getDeclaredMethods();
        for(Method method : methods){
            System.out.printf(method.toString());
        }
        //获取Person类的成员属性信息
        Field[] fields = clazzThree.getFields();
        for(Field field: fields){
            System.out.println(field.toString());
        }
        //获取Person类的构造方法
        Constructor[] constructors = clazzThree.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toString());
        }

    }
}
