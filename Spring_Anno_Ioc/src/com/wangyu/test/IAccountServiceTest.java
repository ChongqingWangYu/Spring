package com.wangyu.test;

import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class IAccountServiceTest {

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setName("小王");
        account.setMoney(1000f);
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        Account account=accountService.findAccount(1);
        account.setMoney(666f);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        accountService.deleteAccount(1);
    }

    @Test
    public void findAccount() {
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        Account account=accountService.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void findAllAccount() {
    }
}