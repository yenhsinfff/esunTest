package com.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiResponse;
import com.user.model.UserDTO_register;
import com.user.model.UserService;
import com.user.model.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userSvc;

	// 註冊
	// http://localhost:8081/user/addUser
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@ModelAttribute UserDTO_register dto) throws IOException{
		UserVO saved = userSvc.addUser(dto);
		ApiResponse<UserVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
	}

}
