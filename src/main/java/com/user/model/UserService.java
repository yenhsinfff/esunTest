package com.user.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	//密碼加密處理
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	// 註冊使用者
	public UserVO addUser(UserDTO_register dto) throws IOException {

		byte[] imageBytes = dto.getCoverImg() != null ? dto.getCoverImg().getBytes() : null;

		UserVO user = new UserVO();
		user.setUserName(dto.getUserName());
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setPhone(dto.getPhone());
		user.setCoverImg(imageBytes);
		user.setBio(dto.getBio());
		return userRepo.save(user);
	}
	
	//登入
	public UserVO login(UserDTO_login dto) {
		UserVO user = userRepo.findByPhone(dto.getPhone());
		if(user == null)
			throw new RuntimeException("找不到此電話號碼");
		if(!encoder.matches(dto.getPassword(), user.getPassword())) //比對使用者傳入的原始密碼和資料庫的加密密碼
			throw new RuntimeException("密碼錯誤");
		
		return user;
	}

}
