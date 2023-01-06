//package com.lab.silent.java.代理;/**
// * Created by zengli on 2021/1/11.
// */
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
///**
// * @ClassName CglibProxyFactory
// * @Description Cglib动态代理
// * @Author ZengLi
// * @Date 2021/1/11 17:03
// * @VerSion 1.0
// **/
//public class CglibProxyFactory implements MethodInterceptor{
//    //得到目标对象
//    private Object target;
//    //使用构造方法传递目标对象
//    public CglibProxyFactory(Object target) {
//        super();
//        this.target = target;
//    }
//    //创建代理对象
//    public Object createProxy(){
//        //1.创建Enhancer
//        Enhancer enhancer = new Enhancer();
//        //2.传递目标对象的class
//        enhancer.setSuperclass(target.getClass());
//        //3.设置回调操作
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//
//    //参数一:代理对象;参数二:需要增强的方法;参数三:需要增强方法的参数;参数四:需要增强的方法的代理
//    @Override
//    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("这是增强方法前......");
//        Object invoke = methodProxy.invoke(target, args);
//        System.out.println("这是增强方法后......");
//        return invoke;
//    }
//
//    public static void main(String[] args) {
//        // 1.创建对象
//        FoodServiceImpl foodService = new FoodServiceImpl();
//        // 2.创建代理对象
//        CglibProxyFactory proxy = new CglibProxyFactory(foodService);
//        // 3.调用代理对象的增强方法,得到增强后的对象
//        FoodService createProxy = (FoodService) proxy.createProxy();
//        createProxy.makeChicken();
//    }
//}