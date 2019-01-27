package com.wangyu.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 *
 * 模拟org.springframework.jdbc.core.support.JdbcDaoSupport
 *
 * @ClassName MyJdbcDaoSupport
 * @Description 抽取dao中的重复代码
 * @Author ChongqingWangYu
 * @DateTime 2019/1/27 15:02
 * @GitHub https://github.com/ChongqingWangYu
 */
public class MyJdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        if (jdbcTemplate == null) {
            createJdbcTemplate(dataSource);
        }
    }

    private void createJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
