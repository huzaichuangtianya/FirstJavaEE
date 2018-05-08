package com.ql.web1.dao.users;

import com.ql.web1.entity.User;

public interface UserMapper {

	public void saveUser(User user);
	
	User getUser(int id);
	
	void updateUser(User user);
	
	void deleteUser(int id);
}
