package com.wangyu.service;

/**
 * 账户的业务层接口
 *
 * @author WangYu
 * @create 2019/01/18 15:17
 */
public interface IAccountService {
    /**
     * 保存账户
     */
    void saveAccount();

    /**
     * 更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deletAccount(int i);
}
