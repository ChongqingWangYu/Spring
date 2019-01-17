package com.wangyu.dao;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * 账户的持久层实现类
 * @author WangYu
 * @create 2019/01/14 13:26
 */
public interface IAccountDao {
    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 根据id删除账户
     * @param accountId
     */
    void delete(Integer accountId);

    /**
     * 更新账户
     * @param account
     */
    void update(Account account);

    /**
     * 保存账户
     * @param account
     */
    void save(Account account);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 根据名称查询账户信息
     * @param sourceName
     * @return 如果根据名称查到唯一，就返回，否则返回null，如果查到结果不唯一，就抛异常。
     */
    Account findById(String sourceName);
}
