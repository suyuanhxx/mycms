package com.mycms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mycms.service.UserService;

public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger.getLogger("service");//log4j，不用解释了吧。。
	
	@Autowired
	private UserService usersService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		UserDetails user = null;

		try {
			com.mycms.model.User tusers = this.usersService.selectByUsername(username);
			user = new User(tusers.getUsername(), tusers.getPwd().toLowerCase(), true, true, true, true, getAuthorities(tusers.getRole()));
		} catch (Exception e) {
			logger.error("用户信息错误！");
			throw new UsernameNotFoundException("异常处理：检索用户信息未通过！");
		}
		return user;
	}

	/**
	 * 获得访问角色权限列表
	 * 
	 * @param access
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(Integer role) {
		System.out.println("取得的权限是  :" + role);
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		// 所有的用户默认拥有ROLE_USER权限
		if (role == 0) {
			System.out.println("普通用户");
			logger.debug("取得普通用户权限-->");
			authList.add(new GrantedAuthorityImpl("ROLE_USERS"));
		}
		// 如果参数role为1.则拥有ROLE_ADMIN权限
		if (role == 1) {
			logger.debug("取得ADMIN用户权限-->");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		System.out.println(authList.size()+"  权限列表长度");
		return authList;
	}
}
