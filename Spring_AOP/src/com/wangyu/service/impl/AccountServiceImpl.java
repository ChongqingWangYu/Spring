package com.wangyu.service.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.dao.impl.AccountDaoImpl;
import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;

import java.util.List;

/**
 * 业务层实现类
 *
 * @author WangYu
 * @create 2019/01/14 12:36
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.delete(accountId);
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //1.根据名称查询转出账户
        Account source = accountDao.findById(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findById(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5.更新转出账户
        accountDao.update(source);
        //模拟转账异常
        int i = 1 / 0;
        //6.更新转入账户
        accountDao.update(target);

    }
}
