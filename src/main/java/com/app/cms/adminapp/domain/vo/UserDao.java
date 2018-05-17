package com.app.cms.adminapp.domain.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getList(){
        String query = "select * from  TB_USER";
        return jdbcTemplate.queryForList(query, new BeanPropertyRowMapper<User>(User.class));
    }

}
