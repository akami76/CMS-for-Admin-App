package com.app.cms.adminapp;

import com.app.cms.adminapp.domain.User;
import com.app.cms.adminapp.repository.UserRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminappApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addUser(){
		User user = new User();
		user.setEmpId("akami");
		user.setEmpNm("관리자");
		userRepository.save(user);


	}

	@Transactional
	@Test
    public void getList(){

        List<User>  users = (List<User>) userRepository.findAll();

        for ( User user: users)
            System.out.println(user.getEmpId());



        //users.forEach(user  -> System.out.println(user.getEmpId()));
    }

}
