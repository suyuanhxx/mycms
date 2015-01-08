package com.mycms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycms.dao.UserMapper;
import com.mycms.model.User;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public boolean insertUser(User user){
		int p=userMapper.insert(user);
		if(p==0) return false;
		return true;
	}
	
	public User selectByUsername(String username){
		return userMapper.selectByUsername(username);
	}

}
