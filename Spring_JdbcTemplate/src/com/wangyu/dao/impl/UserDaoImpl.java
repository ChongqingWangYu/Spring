package com.wangyu.dao.impl;

import com.wangyu.dao.IUserDao;
import com.wangyu.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 用于增删改的方法：
 *      update（String sql，Object...args）；
 *          参数的含义：
 *              String sq1：要执行的sq1语句。该语句可以有占位符。占位符用问号替代。
 *              object.…args：当前执行语句所需的参数。
 * 用于查询一个实体和查询多个实体的方法：
 *      query（String sql，RowMapper，Object...args）；
 *          BeanPropertyRowMapper的使用要求：
 *              要求：实体类中的set方法和数据库表中的列名保持一致。
 *                  setName =name
 *
 * @ClassName UserDaoImpl
 * @Description 用户持久层实现类
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 13:28
 * @GitHub https://github.com/ChongqingWangYu
 */
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> userList = getJdbcTemplate().query("SELECT * FROM users", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findByID(Integer id) {
        List<User> userList = getJdbcTemplate().query("SELECT * FROM users WHERE id=?", new BeanPropertyRowMapper<User>(User.class), id);
        if (userList.size() != 1) {
            throw new RuntimeException("查询结果异常，结果集为:" + userList);
        }
        return userList.get(0);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        getJdbcTemplate().update("DELETE FROM users WHERE id=?", id);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void update(User user) {
        getJdbcTemplate().update("UPDATE users set `name`=?,`password`=?,`group`=? WHERE id=?", user.getName(), user.getPassword(), user.getGroup(), user.getID());
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public void save(User user) {
        getJdbcTemplate().update("INSERT INTO users (`name` ,`password`,`group`)  VALUES (?,?,?)", user.getName(), user.getPassword(), user.getGroup());
    }
}
