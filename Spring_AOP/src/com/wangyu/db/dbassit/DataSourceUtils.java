package com.wangyu.db.dbassit;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 数据源工具类
 *
 * @author WangYu
 * @create 2019/01/17 10:56
 */
public class DataSourceUtils {

    //定义一个线程局部变量
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     * 定义一个方法，用于获取数据源中的Connection
     * @param dataSource                数据源对象
     * @param useCurrentConnection      是否把Connection绑定线程
     * @return
     */
    public static Connection getCurrentConnection(DataSource dataSource, boolean useCurrentConnection) {
        try{
//            1.判断是否需要和线程绑定
            if(!useCurrentConnection){
//                不需要绑定，直接返回Connection对象
                return dataSource.getConnection();
            }
//            2.需要绑定，先从线程上获取连接
            Connection conn =tl.get();
//            3.判断线程上是否已经有连接了
            if(conn==null){
//                没有，从数据源中获取一个连接
                conn=dataSource.getConnection();
//                把获取的连接和线程绑定
                tl.set(conn);
            }
            return tl.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放Connection对象
     * @param currentConnection
     */
    public static void releaseConnection(Connection currentConnection) {
        if(currentConnection!=null){
            try {
//                把连接还回池中
                currentConnection.close();
//                线程局部变量和连接解绑
                tl.remove();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
