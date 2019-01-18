package com.wangyu.utils;

import com.wangyu.dbassit.DBAssit;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类
 *
 * @author WangYu
 * @create 2019/01/17 16:53
 */
public class TransactionManager {

    private static DBAssit dbAssit = new DBAssit(C3P0Utils.getDataSource(),true);
    /**
     * 开启事务（把自动提交关了）
     */
    public static void beginTransaction(){
        try {
            dbAssit.getCurrentConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public static void commit(){
        try {
            dbAssit.getCurrentConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public static void rellback(){
        try {
            dbAssit.getCurrentConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public static void release(){
        try {
            dbAssit.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
