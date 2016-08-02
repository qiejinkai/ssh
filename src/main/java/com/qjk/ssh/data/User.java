package com.qjk.ssh.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.qjk.ssh.group.ValidateInPost;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long uid;
	private String phone;
	private String email;
	private String logo;
	private String nick;
	private String password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
	@NotNull(message="手机号不能为空",groups={ValidateInPost.class})
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@NotNull(message="邮箱不能为空",groups={ValidateInPost.class})
	@Email(message="邮箱格式不正确",groups={ValidateInPost.class})
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@NotNull(message="昵称不能为空",groups={ValidateInPost.class})
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	@NotNull(message="密码不能为空",groups={ValidateInPost.class})
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
