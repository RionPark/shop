package com.furit.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.UserService;
import com.furit.shop.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/users")
	public List<UserVO> getUserList(UserVO user){
		return userService.getUserList(user);	
	}

	@GetMapping("/users/{uiNum}")
	public UserVO getUser(int uiNum){
		return userService.getUser(uiNum);	
	}
	@PostMapping("/users/join")
	public UserVO insertUser(UserVO user){ // @ModelAttribute생략됨
		return userService.insertUser(user);
	}
	
	@PostMapping("/users/login")
	public UserVO login(@RequestBody UserVO user, HttpSession session){ //application/json @RequestBody
		return userService.login(user, session);
	}
	
	@PutMapping("/users")
	public UserVO updateUser(UserVO user, HttpSession session){
		return userService.updateUser(user,session);
	}
	@DeleteMapping("/users")
	public int deleteUser(int uiNum) {
		return userService.deleteUser(uiNum);
	}
}
