package com.wangyu.test;

import com.wangyu.service.IAccountService;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层调用业务层
 *
 * @author WangYu
 * @create 2019/01/18 15:25
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac= new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService=ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deletAccount(1);
    }
}
