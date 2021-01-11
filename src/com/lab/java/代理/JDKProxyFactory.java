package com.lab.java.代理.JDK动态代理;/**
 * Created by zengli on 2021/1/11.
 */

import com.lab.java.代理.FoodService;
import com.lab.java.代理.FoodServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxyFactory
 * @Description jdk动态代理代码
 * @Author ZengLi
 * @Date 2021/1/11 16:46
 * @VerSion 1.0
 **/
public class JDKProxyFactory implements InvocationHandler {

    private Object target;

    public JDKProxyFactory(Object target)
    {
        super();
        this.target = target;
    }

    // 创建代理对象
    public Object createProxy()
    {
        // 1.得到目标对象的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2.得到目标对象的实现接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 3.第三个参数需要一个实现invocationHandler接口的对象
        Object newProxyInstance = Proxy.newProxyInstance(classLoader, interfaces, this);
        return newProxyInstance;
    }

    // 第一个参数:代理对象.一般不使用;第二个参数:需要增强的方法;第三个参数:方法中的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("这是增强方法前......");
        Object invoke = method.invoke(target, args);
        System.out.println("这是增强方法后......");
        return invoke;
    }

    public static void main(String[] args)
    {
        // 1.创建对象
        FoodServiceImpl foodService = new FoodServiceImpl();
        // 2.创建代理对象
        JDKProxyFactory proxy = new JDKProxyFactory(foodService);
        // 3.调用代理对象的增强方法,得到增强后的对象
        FoodService createProxy = (FoodService) proxy.createProxy();
        createProxy.makeChicken();
    }
}