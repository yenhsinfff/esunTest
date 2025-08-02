package com.user.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO_register{
	

	private String userName; // 使用者名稱
	private String email; //使用者電子信箱	
	private String password; //使用者密碼
	private Integer phone; //手機
	private MultipartFile coverImg; //封面照片
	private String bio; //使用者自我介紹
	
	
	public UserDTO_register() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getPhone() {
		return phone;
	}


	public void setPhone(Integer phone) {
		this.phone = phone;
	}


	public MultipartFile getCoverImg() {
		return coverImg;
	}


	public void setCoverImg(MultipartFile coverImg) {
		this.coverImg = coverImg;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


}
