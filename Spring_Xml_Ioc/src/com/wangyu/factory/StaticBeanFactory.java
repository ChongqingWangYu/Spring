package com.wangyu.factory;

import com.wangyu.service.IAccountService;
import com.wangyu.service.impl.AccountServiceImpl;

/**
 * 模拟一个静态工厂
 */
public class StaticBeanFactory {
    public static IAccountService getBean() {
        return new AccountServiceImpl();
    }
}
