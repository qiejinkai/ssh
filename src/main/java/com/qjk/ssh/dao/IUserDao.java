package com.qjk.ssh.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qjk.ssh.data.User;

@Transactional
public interface IUserDao {

	public void addUser(User user);
	
	public void deleteUser(long id);
	
	public User findUserById(long id);
	
	public void updateUser(User user);
	
	public List<User> selectUsers();

	public User findUserByAccount(String account);
	
}
