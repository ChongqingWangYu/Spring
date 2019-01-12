package com.wangyu.ui;

import com.wangyu.dao.IAccountDao;
import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
        Account account=new Account();
        accountService.saveAccount(account);
    }
}
