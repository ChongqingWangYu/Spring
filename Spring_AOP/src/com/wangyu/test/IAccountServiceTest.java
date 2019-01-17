package com.wangyu.test;

import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import com.wangyu.service.impl.AccountServiceImpl_Old;
import org.junit.Test;

import java.util.List;

public class IAccountServiceTest {

    private IAccountService accountService=new AccountServiceImpl_Old();

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setName("bbb");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        Account account=accountService.findAccountById(1);
        account.setMoney(3333f);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        accountService.deleteAccount(1);
    }

    @Test
    public void findAccountById() {
        Account account=accountService.findAccountById(3);
        System.out.println(account);
    }

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }

    @Test
    public void findAllAccount() {
        List<Account> list=accountService.findAllAccount();
        System.out.println(list);
    }

}