package com.wangyu.db.result.impl;

import com.wangyu.db.result.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 封装结果集到指定实体类中
 *
 * @author WangYu
 * @create 2019/01/17 10:27
 */
public class BeanHandler<T> implements ResultSetHandler {
    //    要封装到的javabean字节码对象
    private Class<T> clazz;

    public BeanHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 封装方法
     *
     * @param <T>
     * @param rs
     * @return
     */
    @Override
    public <T> T handler(ResultSet rs) {
        T obj = null;
        try {
//            1.判断是否有结果集
            if (rs.next()) {
//                2.先实例化obj对象
                obj = (T) clazz.newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int count = rsmd.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    // 得到每列的名称
                    String columnName = rsmd.getColumnName(i);
                    // 列名其实就是实体类的属性名称，于是就可以使用列名得到实体类中属性的描述器
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, clazz);
                    // 获取属性的写入方法(set方法)
                    Method method = pd.getWriteMethod();
                    // 获取当前列名所对应的值
                    Object columnValue = rs.getObject(columnName);
                    // 通过执行写方法把得到的值给属性赋上
                    method.invoke(obj, columnValue);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
