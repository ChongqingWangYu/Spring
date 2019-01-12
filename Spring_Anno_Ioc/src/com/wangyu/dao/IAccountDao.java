package com.wangyu.dao;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 查询所有操作
     */
    List<Account> findAll();

    /**
     * 根据id查询操作
     */
    Account findById(Integer accountId);

    /**
     * 删除操作
     */
    void delete(Integer accountId);

    /**
     * 更新操作
     */
    void update(Account account);

    /**
     * 保存操作
     */
    void save(Account account);
}
