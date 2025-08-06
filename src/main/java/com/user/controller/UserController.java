package com.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiResponse;
import com.user.model.UserDTO_login;
import com.user.model.UserDTO_register;
import com.user.model.UserService;
import com.user.model.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userSvc;

	// 註冊
	// http://localhost:8081/user/register
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@ModelAttribute UserDTO_register dto) throws IOException {
		
		try {
		UserVO saved = userSvc.addUser(dto);
		ApiResponse<UserVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
		} catch (IllegalArgumentException e){
			ApiResponse<UserVO> errorResponse = new ApiResponse<>("error", null, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		} catch (Exception e) {
			ApiResponse<UserVO> errorResponse = new ApiResponse<>("error", null, "註冊失敗");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

	// 登入
	// http://localhost:8081/user/login
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO_login dto, HttpSession session){
		UserVO user = userSvc.login(dto);
		session.setAttribute("user", user);
		ApiResponse<UserVO> successResponse = new ApiResponse<>("success", user, "登入成功");
		return ResponseEntity.ok(successResponse);
	}

}
