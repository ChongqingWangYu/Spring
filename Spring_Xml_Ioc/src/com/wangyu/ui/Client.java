package com.wangyu.ui;

import com.wangyu.dao.IAccountDao;
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
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
    }
}
