package com.app.cms.adminapp.service;

import com.app.cms.adminapp.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> findBypage(Pageable pageable) {
        return null;
    }

}
