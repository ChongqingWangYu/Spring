package com.wangyu.service.impl;

import com.wangyu.dao.IUserDao;
import com.wangyu.entity.User;
import com.wangyu.service.IUserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务层实现类
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 13:26
 * @GitHub https://github.com/ChongqingWangYu
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDaoImpl;
    public void setUserDaoImpl(IUserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public void SaveUser(User user) {
        userDaoImpl.save(user);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void UpdateUser(User user) {
        userDaoImpl.update(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void DeleteUser(Integer id) {
        userDaoImpl.delete(id);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findByID(Integer id) {
        User user = userDaoImpl.findByID(id);
        return user;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> userList = userDaoImpl.findAll();
        return userList;
    }
}
