package com.atm.usermessage;

/**
 * 用来保存查询结果的类
 * @author 周宝辉
 *
 */
public class UserMessage {
	private String userid;
	private String userpassword;
	private String usermoney;
	private String username;
	private String usersex;
	private String userphone;
	private String userhome;

	public UserMessage() {
	}

	public UserMessage(String userId, String userPassword) {
		this.userid = userId;
		this.userpassword = userPassword;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsermoney() {
		return usermoney;
	}

	public void setUsermoney(String usermoney) {
		this.usermoney = usermoney;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserhome() {
		return userhome;
	}

	public void setUserhome(String userhome) {
		this.userhome = userhome;
	}
}