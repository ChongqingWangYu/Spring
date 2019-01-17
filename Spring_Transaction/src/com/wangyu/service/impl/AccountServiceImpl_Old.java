package com.wangyu.service.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.dao.impl.AccountDaoImpl;
import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import com.wangyu.utils.TransactionManager;

import java.util.List;

/**
 * 业务层实现类
 *在javaee分层开发中，事务一般都是处于业务层的。
 * @author WangYu
 * @create 2019/01/14 12:36
 */
public class AccountServiceImpl_Old implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount(Account account) {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
            accountDao.save(account);
//        3.提交事务
            TransactionManager.commit();
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
        }finally {
//        5.释放资源
            TransactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
            accountDao.update(account);
//        3.提交事务
            TransactionManager.commit();
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
        }finally {
//        5.释放资源
            TransactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
            accountDao.delete(accountId);
//        3.提交事务
            TransactionManager.commit();
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
        }finally {
//        5.释放资源
            TransactionManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
            Account account=accountDao.findById(accountId);
//        3.提交事务
            TransactionManager.commit();
            return account;
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
            throw new RuntimeException(e);
        }finally {
//        5.释放资源
            TransactionManager.release();
        }
    }

    @Override
    public List<Account> findAllAccount() {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
            List<Account> accounts=accountDao.findAll();
//        3.提交事务
            TransactionManager.commit();
            return accounts;
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
            throw new RuntimeException(e);
        }finally {
//        5.释放资源
            TransactionManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
//        1.开启事务
            TransactionManager.beginTransaction();
//        2.执行调用业务层方法
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
//            int i = 1 / 0;
            //6.更新转入账户
            accountDao.update(target);
//        3.提交事务
            TransactionManager.commit();
        }catch (Exception e){
//        4.回滚事务
            TransactionManager.rellback();
            throw new RuntimeException(e);
        }finally {
//        5.释放资源
            TransactionManager.release();
        }


    }
}
