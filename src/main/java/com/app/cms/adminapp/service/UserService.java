package com.app.cms.adminapp.service;

import com.app.cms.adminapp.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    public List<User> findBypage(Pageable pageable);


}
