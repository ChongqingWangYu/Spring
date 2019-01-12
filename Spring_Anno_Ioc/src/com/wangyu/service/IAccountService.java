package com.wangyu.service;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口（模拟）
 */
public interface IAccountService {
    /**
     * 保存账户
     */
    void saveAccount(Account account);
    /**
     * 更新账户
     */
    void updateAccount(Account account);
    /**
     * 删除账户
     */
    void deleteAccount(Integer accountId);
    /**
     * 根据id查询账户
     */
    Account findAccount(Integer accountId);
    /**
     * 查询所有账户
     */
    List<Account> findAllAccount();
}
