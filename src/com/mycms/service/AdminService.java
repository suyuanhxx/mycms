package com.mycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycms.dao.AdminMapper;
import com.mycms.model.Admin;


@Service("adminService")
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public boolean insertAdmin(Admin vo){
		int p=adminMapper.insert(vo);
		if(p==1)return true;
		return false;
	}
	
	public Admin selectByUsername(String username){
		return adminMapper.selectByUsername(username);
	}
}
