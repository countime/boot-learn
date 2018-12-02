package com.countime.bootlearn.HelloWordController;

import com.countime.bootlearn.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/jdbctest/select", method = RequestMethod.GET)
    public List<UserEntity> select() {
        String sql = "select * from mh_user";
        List<UserEntity> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
        return list;
    }

    @RequestMapping(value = "/jdbctest/insert", method = RequestMethod.GET)
    public String insert() {
        String sql = "INSERT INTO mh_user (name, age, created) values (?,?,?)";
        int rows = jdbcTemplate.update(sql, "happy", 18, new Date());
        return "更新或者插入的行数: " + rows;
    }
}
