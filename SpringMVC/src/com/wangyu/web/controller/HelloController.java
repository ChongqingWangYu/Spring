package com.wangyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
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
