package com.wangyu.dao.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.domain.Account;
import com.wangyu.util.DBAssit;
import com.wangyu.util.impl.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private DBAssit dbAssit;

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Integer accountId) {
        return (Account) dbAssit.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
    }

    @Override
    public void delete(Integer accountId) {
        dbAssit.update("delete from account where id=?",accountId);
    }

    @Override
    public void update(Account account) {
        dbAssit.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void save(Account account) {
        dbAssit.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }
}
