package com.wangyu.service;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 保存账户
     * @param account
     */
    void  saveAccount(Account account);

    /**
     *  更新账户
     * @param account
     */
    void  updateAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
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

    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
