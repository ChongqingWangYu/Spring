package com.wangyu.db.result;

import java.sql.ResultSet;

/**
 * 结果集封装处理器接口
 */
public interface ResultSetHandler {
    /**
     * 封装结果集
     * @param <T>
     * @param rs
     * @return
     */
    public <T> T handler(ResultSet rs);
}
