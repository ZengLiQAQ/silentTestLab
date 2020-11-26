package com.lab.java.juc.relect;/**
 * Created by zengli on 2020/11/24.
 */

/**
 * @ClassName Person
 * @Description TODO
 * @Author ZengLi
 * @Date 2020/11/24 16:57
 * @VerSion 1.0
 **/
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
