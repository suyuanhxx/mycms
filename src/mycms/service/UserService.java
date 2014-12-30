package mycms.service;

import mycms.dao.UserMapper;
import mycms.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public boolean insertUser(User user){
		int p=userMapper.insert(user);
		if(p==0) return false;
		return true;
	}

}
