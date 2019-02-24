package com.wangyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入门案例执行过程
 * 1：tomcat启动：加载应用的web.xml
 * 2：实例化并初始化Servlet
 * 3：加载sprmgmvc.xml配置文件创建spring容器，根据配置初始化容器中的对象
 * 4：客户端发送请求：helo
 * 5：请求到达前端控制器
 * 6：截取请求的动作名称helld，并从@RequestMapping中找
 * 7：找到后，执行控制器中的方法
 * 8：方法有返回值，根据返回值通过InternalResourceViewResolver找到响应的结果视图
 * @ClassName HelloController
 * @Description SpringMVC的第一个控制器：它就是一个普通的Java类
 * @Author ChongqingWangYu
 * @DateTime 2019/2/21 11:13
 * @GitHub https://github.com/ChongqingWangYu
 */
//使用spring中的注解保证当前这个类让spring来管理
@Controller("helloController")
public class HelloController {
    {
        System.out.println(111111111);
    }
    //请求的映射：他要求和浏览器请求的url保持一致
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("HelloController的sayHello执行了！");
        return "success";
    }

}
