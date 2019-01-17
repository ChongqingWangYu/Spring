package com.wangyu.proxy;

/**
 * 一个经销商，可能会代理很多厂家
 */
public interface IAgent {
    /**
     * 销售电脑
     */
    public void sale(Float money);

    /**
     * 售后服务
     */
    public void afterService(Float money);
}
