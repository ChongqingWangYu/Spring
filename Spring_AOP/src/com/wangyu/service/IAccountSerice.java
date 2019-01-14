package com.wangyu.service;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountSerice {
    /**
     * 保存账户
     * @param account
     */
    void  saveAccount(Account account);

    /**
     *
     * @param account
     */
    void  updateAccount(Account account);

    void  deleteAccount(Integer accountId);

    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();
}
