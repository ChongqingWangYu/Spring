package com.wangyu.test;

import com.wangyu.service.IAccountService;
import com.wangyu.service.impl.AccountServiceImpl;
import com.wangyu.utils.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层调用业务层
 *
 * @author WangYu
 * @create 2019/01/18 15:25
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deletAccount(1);
    }
}
