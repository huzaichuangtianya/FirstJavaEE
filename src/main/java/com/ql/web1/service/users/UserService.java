package com.ql.web1.service.users;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ql.web1.entity.User;

public interface UserService {
	
	public void saveUser(User user);
	 User getUser(int id);
		void updateUser(User user);
		void deleteUser(int id);
	
}
