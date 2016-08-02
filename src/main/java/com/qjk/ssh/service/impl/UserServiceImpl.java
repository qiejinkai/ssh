package com.qjk.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qjk.ssh.dao.IUserDao;
import com.qjk.ssh.data.User;
import com.qjk.ssh.exception.UserException;
import com.qjk.ssh.service.IUserService;
import com.qjk.ssh.util.DigestUtil;
import com.qjk.ssh.util.Value;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public void addUser(User user) {

		String password = user.getPassword();

		if (!Value.isEmpty(password)) {
			user.setPassword(DigestUtil.encodePassword(password));
		}

		userDao.addUser(user);


	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(User user) {
		if (user != null && user.getUid() != 0) {
			userDao.deleteUser(user.getUid());
		}

	}

	public User findUserById(long id) {
		User user = userDao.findUserById(id);
		user.setPassword(null);
		return user;

	}

	public List<User> queryUser() {
		return userDao.selectUsers();
	}

	public User login(String account, String password) throws UserException {

		if (Value.isEmpty(account)) {
			throw new UserException("请输入手机号或email");
		}
		if (Value.isEmpty(password)) {
			throw new UserException("请输入密码");
		}

		User user = null;

		user = userDao.findUserByAccount(account);

		if (user == null) {
			throw new UserException("用户不存在");
		}
		if (!DigestUtil.encodePassword(password).equals(user.getPassword())) {
			throw new UserException("密码不正确");
		}

		return user;

	}

	public User joinEmail(String email, String password) throws UserException {
		
		if (Value.isEmpty(email)) {
			throw new UserException("请输入email");
		}
		if (Value.isEmpty(password)) {
			throw new UserException("请输入密码");
		}

		User user = null;

		user = userDao.findUserByAccount(email);

		if (user != null) {
			throw new UserException("email已被使用");
		}
		
		user = new User();
		user.setEmail(email);
		user.setPassword(DigestUtil.encodePassword(password));
		user.setNick(email);
		
		userDao.addUser(user);

		return user;

	}

	public User joinPhone(String phone, String password) throws UserException {
		
		if (Value.isEmpty(phone)) {
			throw new UserException("请输入手机号");
		}
		if (Value.isEmpty(password)) {
			throw new UserException("请输入密码");
		}

		User user = null;

		user = userDao.findUserByAccount(phone);

		if (user != null) {
			throw new UserException("手机号已被使用");
		}
		
		user = new User();
		user.setPhone(phone);
		user.setPassword(DigestUtil.encodePassword(password));
		user.setNick(phone);
		 userDao.addUser(user);

		return user;
	}

}
