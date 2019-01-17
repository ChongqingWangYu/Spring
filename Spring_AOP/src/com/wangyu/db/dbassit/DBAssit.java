package com.wangyu.db.dbassit;


import com.wangyu.db.result.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 数据库操作助手
 *
 * @author WangYu
 * @create 2019/01/17 9:59
 */
public class DBAssit {

    //    定义一个数据源
    private DataSource dataSource;

    //    提供一个set方法注入
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //    定义一个变量，用于设置Connection和线程是否绑定
    private boolean useCurrentConnection = false;

    public void setUseCurrentConnection(boolean useCurrentConnection) {
        this.useCurrentConnection = useCurrentConnection;
    }

    /**
     * 获取当前正在使用的Connection对象
     * 是否和线程绑定需要看useCurrentConnection变量的取值
     *
     * @return
     */
    public Connection getCurrentConnection() {
        return DataSourceUtils.getCurrentConnection(dataSource, useCurrentConnection);
    }

    /**
     * 释放Connection
     */
    public void releaseConnection() {
        DataSourceUtils.releaseConnection(getCurrentConnection());
    }

    //    默认构造函数
    public DBAssit() {

    }

    /**
     * 每条语句独立事物的代餐构造
     *
     * @param dataSource 数据源
     */
    public DBAssit(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 需要多条语句共用同一事务的带参构造
     *
     * @param dataSource           数据源
     * @param useCurrentConnection 是否需要线程绑定
     */
    public DBAssit(DataSource dataSource, boolean useCurrentConnection) {
        this.dataSource = dataSource;
        this.useCurrentConnection = useCurrentConnection;
    }

    /**
     * 增删改方法
     *
     * @param sql    操作的语句
     * @param params 语句所需的参数
     * @return 英雄数据库记录的行数
     */
    public int update(String sql, Object... params) {
//        1.对象的定义
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
//            2.获取Connection
            conn = getCurrentConnection();
//            3.获取预处理操作对象
            pstm = conn.prepareStatement(sql);
//            4.通过数据库的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
//            5.获取语句的参数个数
            int count = pmd.getParameterCount();
//            6.判断参数是否匹配
            setParameter(pstm, count, params);
//            7.执行语句，获取结果集
            return pstm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            8.释放资源
            close(conn, pstm, useCurrentConnection);
        }
    }

    public <T> Object query(String sql, ResultSetHandler rsh, Object... params) {
//        1.对象的定义
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
//            2.从数数据源中获取连接
            conn = dataSource.getConnection();
//            3.获取预处理操作对象
            pstm = conn.prepareStatement(sql);
//            4.通过数据库的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
//            5.获取语句的参数个数
            int count = pmd.getParameterCount();
//            6.判断参数是否匹配
            setParameter(pstm, count, params);
            return rsh.handler(pstm.executeQuery());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, pstm, useCurrentConnection);
        }
    }

    private void setParameter(PreparedStatement pstm, int count, Object[] params) throws SQLException {
        if (count > 0) {
//                有参数
            if (params == null) {
//                    没有传入参数
                throw new IllegalArgumentException("没有传入有效的参数");
            }
            if (count != params.length) {
//                    占位符个数和参数个数不匹配
                throw new IllegalArgumentException("占位符个数和参数个数不匹配");
            }
//                给占位符赋值
            for (int i = 0; i < count; i++) {
                pstm.setObject(i + 1, params[i]);
            }
        }
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param pstm
     * @param o
     */
    private void close(Connection conn, PreparedStatement pstm, Object o) {
        if(useCurrentConnection){
            return;
        }
        try {
            if (!conn.isClosed())
                conn.close();
            if (!pstm.isClosed())
                pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
