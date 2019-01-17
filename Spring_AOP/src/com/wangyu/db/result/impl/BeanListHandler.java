package com.wangyu.db.result.impl;

import com.wangyu.db.result.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装结果集到集合中
 *
 * @author WangYu
 * @create 2019/01/17 10:30
 */
public class BeanListHandler<T> implements ResultSetHandler {

    //    要封装到的javabean字节码对象
    private Class<T> clazz;

    public BeanListHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> handler(ResultSet rs) {
        T obj = null;
        List<T> list = null;
        try {
            list = new ArrayList<T>();
//            1.判断是否有结果集
            while (rs.next()) {
                obj = clazz.newInstance();
                //3.得到结果集rs中所有的列名
                //要想得到列名，得先得到结果集的源信息
                ResultSetMetaData rsmd = rs.getMetaData();
                //得到源信息之后，还要得到有多少列
                int columnCount = rsmd.getColumnCount();
                //遍历列数
                for (int i = 1; i <= columnCount; i++) {
                    //得到每列的名称
                    String columnName = rsmd.getColumnName(i);
                    //列名其实就是实体类的属性名称，于是就可以使用列名得到实体类中属性的描述器
                    //实体类中定义的私有类成员和它的get以及set方法
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, clazz);
                    //获取属性的写入方法(set方法)
                    Method method = pd.getWriteMethod();
                    //获取当前列名所对应的值
                    Object columnValue = rs.getObject(columnName);
                    //通过执行写方法把得到的值给属性赋上
                    method.invoke(obj, columnValue);
                    list.add(obj);
                }
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
