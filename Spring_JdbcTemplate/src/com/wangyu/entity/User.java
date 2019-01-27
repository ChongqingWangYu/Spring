package com.wangyu.entity;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 11:11
 * @GitHub https://github.com/ChongqingWangYu
 */
public class User {

    /**
     * 自动递增的编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户组（管理或用户）
     */
    private String group;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public Integer getID() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public User() {
    }

    public User(Integer id, String name, String password, String group) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.group = group;
    }
}
