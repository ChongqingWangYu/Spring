package com.wangyu.service;

import com.wangyu.entity.User;

import java.util.List;

/**
 * @ClassName IUserService
 * @Description 用户业务层接口
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 11:18
 * @GitHub https://github.com/ChongqingWangYu
 */
public interface IUserService {
    /**
     * 保存用户
     *
     * @param user
     */
    void SaveUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void UpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void DeleteUser(Integer id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User findByID(Integer id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();
}
