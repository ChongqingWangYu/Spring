package com.wangyu.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
         *      提供者：cglib第三方的
         *      涉及的类：Ehancer
         *      创建代理对象的方法：create
         *      方法的参数：
         *          Class：字节码。指定被代理对象的字节码。
         *          Callback：如何代理。
         *      使用要求：被代理类不能是最终类。
         */
        ComputerFactory cglibFactory = (ComputerFactory) Enhancer.create(factory.getClass(), new MethodInterceptor() {
            /**
             * 它和InvocationHandler中的invoke方法作用是一样的，
             * 该方法的前3个参数和invoke方法的三个参数作用是一样的，
             * 该方法的返回值和invoke方法的返回值作用也是一样的。
             * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
                //1.获取正在执行方法的参数
                Float money = (Float) objects[0];
                //2.判断正在执行的方法
                if ("sale".equals(method.getName())) {
                    //低于1600免谈
                    if (money > 7000) {
                        //经销商收取费用
                        rtValue = method.invoke(factory, money / 2);
                    }
                }
                if ("afterService".equals(method.getName())) {
                    //低于1600免谈
                    if (money > 1600) {
                        //经销商收取费用
                        rtValue = method.invoke(factory, money / 4 * 3);
                    }
                }
                return rtValue;
            }
        });
        cglibFactory.sale(8000f);
        cglibFactory.afterService(1800f);
    }
}
