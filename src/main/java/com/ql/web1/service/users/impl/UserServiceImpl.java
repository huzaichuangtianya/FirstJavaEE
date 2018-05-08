package com.ql.web1.service.users.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ql.web1.dao.users.UserMapper;
import com.ql.web1.entity.User;
import com.ql.web1.service.users.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.saveUser(user);
		
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUser(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}

}
