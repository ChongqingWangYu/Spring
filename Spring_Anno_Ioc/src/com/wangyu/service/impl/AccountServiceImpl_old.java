package com.wangyu.service.impl;

import com.wangyu.dao.IAccountDao;
import com.wangyu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户业务层的实现类
 * XML的配置：
 * <bean id="accountService"class="com.wangyu.service.impl.AccountServiceImpl_old">
 * <property name="accountDao"ref="accountDao"></property>
 * 用于创建对象的：
 *     @Component:
 *         作用：就相当于在spring的xml配置文件中写了一个bean标签。
 *         属性：
 *             value:用于指定bean的id，当不写时默认值是当前类名，首字母改小写，例如：accountServiceImpl
 *     由此注解衍生的三个注解：
 *         @Controller:一般用于表现层
 *         @Service:一般用于业务层
 *         @Repository:一般用于持久层
 *     他们的作用以及属性和@Component的作用是一模一样的，他们的出现是spring框架为我们提供更明确的语义来指定不同层的bean对象。
 *
 * 用于注入数据的：
 *     用于注入其他bean类型的注解：
 *     @Autowired
 *         作用：自动按照类型注入。只要容器中有唯一的类型匹配，则可以直接注入成功。
 *              如果有多个类型匹配时，会先按照类型找到符合条件的对象，然后再用变量名称作为bean的id，从里面继续查找，如果找到仍然可以注入成功，如果没有匹配的id，则报错。
 *         细节：当使用此注解注入时，set方法可以省略。
 *         属性：
 *             required：是否必须注入成功，取值是true（默认组）/false，当取值是true时，没有匹配的对象就报错。
 *     @Qualifier
 *         作用：在自动按照类型注入的基础之上，再按照bean的id注入。在给类成员注入时，它不能够独立使用。
 *         属性：
 *             value：用于指定bean的id。
 *     @Resource
 *         作用：直接按照bean的id注入。
 *         属性：
 *              name：用于指定bean的id。
 *     以上3个注解，都只能用于注入其他bean类型，而不能注入基本类型和String。
 *
 *     用于注入基本类型和String类型的数据：
 *     @Value
 *         作用：用于注入基本类型和string类型的数据。
 *         属性：
 *             value：用于指定要注入的数据。它支持使用spring的el表达式
 *                 spring的el表达式写法：${表达式}
 *
 * 用于改变作用范围：
 *     @Scope
 *         作用：用于改变bean的作用范围。取值和xml中的配置是一样的。
 *         属性：
 *             value：用于指定范围。
 *
 * 和生命周期相关的：
 *     @PostContruct
 *         作用：用于指定初始化方法。和配置文件中init-method属性是一样的
 *     @PreDestroy
 *         作用：用于指定销毁方法。和配置文件中destroy-method属性是一样的
 */
//@Service("accountService")//若不定义id，则默认为accountServiceImpl
//@Scope("prototype")//多例
public class AccountServiceImpl_old {//implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    /**
     *  需要告知spring配置文件的位置<context:property-placeholder location="jdbcConfig.properties"/>
     */
    @Value("${jdbc.driver}")
    private String driver;

    @PostConstruct
    public void init(){
        System.out.println("对象初始化了");
    }
    @PreDestroy
    public void destroy(){
//        当容器销毁时执行，多例时由java垃圾回收自动销毁
        System.out.println("对象销毁了");
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

//    @Override
    public void saveAccount() {
        System.out.println(driver);
//        accountDao.saveAccount();
    }
}
