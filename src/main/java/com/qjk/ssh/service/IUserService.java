package com.qjk.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qjk.ssh.data.User;
import com.qjk.ssh.exception.UserException;

@Transactional
public interface IUserService {
	
	User joinPhone(String phone,String password) throws UserException;
	
	User joinEmail(String email,String password) throws UserException;
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User login(String account,String password) throws UserException;
	
	User findUserById(long id);
	
	List<User> queryUser();
	
}
