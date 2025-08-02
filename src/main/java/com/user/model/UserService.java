package com.user.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	// 註冊使用者
		public UserVO addUser(UserDTO_register dto) throws IOException {

			byte[] imageBytes = dto.getCoverImg() != null ? dto.getCoverImg().getBytes() : null;

			UserVO user = new UserVO();
			user.setUserName(dto.getUserName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setPhone(dto.getPhone());
			user.setCoverImg(imageBytes);
			user.setBio(dto.getBio());
			return userRepo.save(user);
		}

}
