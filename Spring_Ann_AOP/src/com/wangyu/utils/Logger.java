package com.wangyu.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 一个通知类，用于对业务层方法增强，模拟记录日志
 *
 * @author WangYu
 * @create 2019/01/18 15:27
 */

@Component("logger")
@Aspect//把当前类配置为一个切面
public class Logger {

    @Pointcut("execution(* com.wangyu.service.impl.*.*(..))")
    private void pt1(){ }

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了。。。前置");
    }

    /**
     * 后置
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("Logger类中的beforeReturningPrintLog方法开始记录日志了。。。后置");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志了。。。异常");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("Logger类中的afterPrintLog方法开始记录日志了。。。最终");
    }
    /**
     * 环绕通知
     */
//    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue=null;
        try {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。前置");
            //获取方法所需的参数
            Object[] args=pjp.getArgs();
            rtValue=pjp.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。后置");
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。异常");
            throwable.printStackTrace();
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }
        return rtValue;
    }


}
