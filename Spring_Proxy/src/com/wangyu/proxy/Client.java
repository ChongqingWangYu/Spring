package com.wangyu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个消费者
 *
 * @author WangYu
 * @create 2019/01/17 20:33
 */
public class Client {

    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        //由经销商为我们联系厂家提供电脑
        /**
         * 动态代理
         *  特点：字节码随用随创建，随用随加载
         *  分类：
         *      基于接口的
         *      基于子类的
         *  作用：
         *      在不改变源码的基础上对已有方法增强
         *  此类讲解的是基于接口的动态代理
         *      提供者：JDK官方
         *      涉及的类：Proxy
         *      创建代理对象的方法：newProxyInstance
         *      方法的参数：
         *          ClassLoader：类加载器，和被代理对象使用相同的类加载器。该参数是固定写法。
         *          Class[]：字节码数组，和被代理对象具有相同的行为，实现相同的接口。
         *          InvocationHandler：它是一个接口，提供如何代理的代码。也就是增强的代码。该参数一般都写成匿名内部类。
         *                          并且它是策略模式的体现。
         *                          策略模式：
         *                              要求：数据已经有了，目的明确。
         *                                  达成目标的过程就是策略。
         *                              该参数是谁用谁写。
         *      使用要求：被代理类最少实现一个接口。
         */
        IAgent proxyFactory = (IAgent) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces()
                , new InvocationHandler() {
                    /**
                     * 该方法的特征：执行被代理对象的任何方法都会经过该方法。该方法有拦截的特点。
                     *
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需的参数
                     * @return 和被代理对象的方法返回值一致
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        //1.获取正在执行方法的参数
                        Float money= (Float) args[0];
                        //2.判断正在执行的方法
                        if("sale".equals(method.getName())){
                            //低于1600免谈
                            if(money>7000) {
                                //经销商收取费用
                                rtValue=method.invoke(factory,money/2);
                            }
                        }
                        if ("afterService".equals(method.getName())){
                            //低于1600免谈
                            if(money>1600) {
                                //经销商收取费用
                                rtValue=method.invoke(factory,money/4*3);
                            }
                        }
                        return rtValue;
                    }
                });
        proxyFactory.sale(10000f);
        proxyFactory.afterService(2000f);
    }
}
