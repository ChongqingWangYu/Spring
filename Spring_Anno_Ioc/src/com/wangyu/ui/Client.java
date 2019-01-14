package com.wangyu.ui;

import com.wangyu.dao.IAccountDao;
import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import config.SpringConfiguration;
import org.jboss.arquillian.core.api.annotation.ApplicationScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


public class Client {
    /**
     *
     * @param args
     */
    @Autowired
    private static IAccountService accountService;
    @Autowired
    private static IAccountDao accountDao;

    public static void main(String[] args) {
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
//        IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
        Account account=new Account();
        accountService.saveAccount(account);
    }
}
