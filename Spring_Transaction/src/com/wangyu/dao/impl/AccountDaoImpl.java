package com.wangyu.dao.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.dbassit.DBAssit;
import com.wangyu.domain.Account;
import com.wangyu.result.impl.BeanHandler;
import com.wangyu.result.impl.BeanListHandler;
import com.wangyu.utils.C3P0Utils;

import java.util.List;

/**
 * @author WangYu
 * @create 2019/01/14 13:26
 */
public class AccountDaoImpl implements IAccountDao {

    private DBAssit dbAssit = new DBAssit(C3P0Utils.getDataSource(),true);

    @Override
    public Account findById(Integer accountId) {

        return (Account) dbAssit.query("select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
    }

    @Override
    public void delete(Integer accountId) {
        dbAssit.update("delete from account where id=?", accountId);
    }

    @Override
    public void update(Account account) {
        dbAssit.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void save(Account account) {
        dbAssit.update("insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) dbAssit.query("select * from account", new BeanListHandler<>(Account.class));
    }

    @Override
    public Account findById(String sourceName) {
        return (Account) dbAssit.query("select * from account where name=?", new BeanHandler<Account>(Account.class), sourceName);
    }
}
