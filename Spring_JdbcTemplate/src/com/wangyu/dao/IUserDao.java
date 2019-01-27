package com.wangyu.dao;

import com.wangyu.entity.User;

import java.util.List;

/**
 * @ClassName IUserDao
 * @Description 用户持久层接口
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 13:28
 * @GitHub https://github.com/ChongqingWangYu
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findByID(Integer id);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 保存用户
     * @param user
     */
    void save(User user);
}
