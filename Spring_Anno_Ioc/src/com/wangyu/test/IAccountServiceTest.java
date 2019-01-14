package com.wangyu.test;

import com.wangyu.domain.Account;
import com.wangyu.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//使用Junit提供的@RunWith注解把原有的运行器替换掉，替换成spring提供的
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)//使用spring提供的一个注解，告知运行器spring配置文件的位置
public class IAccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setName("小王");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        Account account=accountService.findAccount(1);
        account.setMoney(666f);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        accountService.deleteAccount(1);
    }

    @Test
    public void findAccount() {
        Account account=accountService.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void findAllAccount() {
    }
}