package com.wangyu.db.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * C3P0工具类
 *
 * @author WangYu
 * @create 2019/01/14 14:16
 */
public class C3P0Utils {
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public static DataSource getDataSource() {
        return comboPooledDataSource;
    }
}
