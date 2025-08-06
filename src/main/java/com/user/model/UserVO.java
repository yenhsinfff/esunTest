package com.user.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserVO implements Serializable{
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId; // 使用者ID
	
	@Column(name = "user_name", nullable = false)
	private String userName; // 使用者名稱
	
	@Column(name = "email", nullable = false)
	private String email; //使用者電子信箱
	
	@Column(name = "password", nullable = false)
	private String password; //使用者密碼
	
	@Column(name = "phone", nullable = false)
	private String phone; //手機
	
	@Lob
	@Column(name = "coverImage", columnDefinition = "longblob")
	private byte[] coverImg; //封面照片
	
	@Column(name = "biography", nullable = false)
	private String bio; //使用者自我介紹
	
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(Integer userId, String userName, String email, String password, String phone, byte[] coverImg,
			String bio) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.coverImg = coverImg;
		this.bio = bio;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(byte[] coverImg) {
		this.coverImg = coverImg;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coverImg);
		result = prime * result + Objects.hash(bio, email, password, phone, userId, userName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(bio, other.bio) && Arrays.equals(coverImg, other.coverImg)
				&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", coverImg=" + Arrays.toString(coverImg) + ", bio=" + bio + "]";
	}
	
	
	
}
