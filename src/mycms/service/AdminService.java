package mycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycms.dao.AdminMapper;
import mycms.model.Admin;

@Service("adminService")
public class AdminService {
	
	private AdminMapper adminMapper;

	@Autowired
	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	public boolean insertAdmin(Admin vo){
		int p=adminMapper.insert(vo);
		if(p==1)return true;
		return false;
	}
	
	public Admin selectByUsername(String username){
		return adminMapper.selectByUsername(username);
	}
}
