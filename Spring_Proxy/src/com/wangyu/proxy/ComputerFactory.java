package com.wangyu.proxy;

/**
 * 电脑生产厂家
 *
 * @author WangYu
 * @create 2019/01/17 20:09
 */
public class ComputerFactory implements IAgent{

    /**
     * 销售电脑
     * @param money
     */
    @Override
    public void sale(Float money){
        System.out.println("收到钱，把电脑给消费者："+money);
    }

    /**
     * 售后服务
     * @param money
     */
    @Override
    public void afterService(Float money){
        System.out.println("收到钱，开始给消费者提供售后服务："+money);
    }

}
