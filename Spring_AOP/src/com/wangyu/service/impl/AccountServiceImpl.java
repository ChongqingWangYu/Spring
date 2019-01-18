package com.wangyu.service.impl;

import com.wangyu.service.IAccountService;

/**
 * 账户业务层的实现类
 *
 * @author WangYu
 * @create 2019/01/18 15:19
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户"+i);
    }

    @Override
    public int deletAccount(int i) {
        System.out.println("删除了了账户"+i);
        return 0;
    }
}
