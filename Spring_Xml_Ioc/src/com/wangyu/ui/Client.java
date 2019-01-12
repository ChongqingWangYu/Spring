package com.wangyu.ui;

import com.wangyu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /**
     * 获取Spring的核心容器，并且根据bean的id获取对象
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取Spring的核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        //  默认构造函数创建
        //  IAccountService as = (IAccountService) ac.getBean("accountService");
        //  静态工厂创建
        //  IAccountService as = (IAccountService) ac.getBean("staticAccountService");
        //  实例工厂创建
        IAccountService as = (IAccountService) ac.getBean("instanceAccountService");
        System.out.println(as);
    }
}
