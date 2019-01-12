package com.wangyu.factory;

import com.wangyu.service.IAccountService;
import com.wangyu.service.impl.AccountServiceImpl;

/**
 * 模拟一个实例工厂
 */
public class InstanceBeanFactory {
    public IAccountService getBean() {
        return new AccountServiceImpl();
    }
}
