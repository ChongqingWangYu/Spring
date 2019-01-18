package com.wangyu.factory;

import com.wangyu.service.IAccountService;
import com.wangyu.service.impl.AccountServiceImpl;
import com.wangyu.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生产业务层代理对象的工厂类
 *
 * @author WangYu
 * @create 2019/01/18 13:57
 */
public class BeanFactory {
    public static IAccountService getProxyAccountService() {
        IAccountService accountService = new AccountServiceImpl();
        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces()
                , new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //        1.开启事务
                            TransactionManager.beginTransaction();
                            //        2.执行调用业务层方法
                            rtValue=method.invoke(accountService, args);
                            //        3.提交事务
                            TransactionManager.commit();
                        } catch (Exception e) {
                            //        4.回滚事务
                            TransactionManager.rellback();
                            throw new RuntimeException(e);
                        } finally {
                            //        5.释放资源
                            TransactionManager.release();
                        }
                        return rtValue;
                    }
                });
        return proxyAccountService;
    }
}
