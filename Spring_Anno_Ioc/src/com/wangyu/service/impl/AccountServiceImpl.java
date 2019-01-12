package com.wangyu.service.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

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
    public Account findAccount(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }
}
