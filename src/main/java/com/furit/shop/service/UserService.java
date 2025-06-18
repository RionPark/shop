package com.furit.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furit.shop.mapper.UserMapper;
import com.furit.shop.util.FileUtils;
import com.furit.shop.util.SHA256Utils;
import com.furit.shop.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final FileUtils fileUtil;
	
	public List<UserVO> getUserList(UserVO user){
		return userMapper.selectUserList(user);	
	}
	
	public UserVO getUser(int uiNum){
		return userMapper.selectUser(uiNum);	
	}
	
	public UserVO getUserById(String uiId){
		return userMapper.selectUserById(uiId);	
	}
	public UserVO login(UserVO user, HttpSession session) {
		UserVO dbUser = userMapper.selectUserById(user.getUiId());
		String uiPwd = user.getUiPwd();
		uiPwd = SHA256Utils.encodePwd(uiPwd);
		
		if(!uiPwd.equals(dbUser.getUiPwd())) {
			throw new RuntimeException("아이디 비밀번호를 확인하세요");
		}
		dbUser.setUiPwd(null);
		session.setAttribute("user", dbUser);
		return dbUser;
	}
	
	public UserVO insertUser(UserVO user){ //uiId, uiPwd, uiName, uiProfile
		String uiPwd = user.getUiPwd();
		uiPwd = SHA256Utils.encodePwd(uiPwd);
		user.setUiPwd(uiPwd);
		String uiProfileImg = fileUtil.saveFile(user.getUiProfile(), "profile");
		user.setUiProfileImg(uiProfileImg);
		userMapper.insertUser(user);
		user.setUiProfile(null);
		return user;
	}
	
	public UserVO updateUser(UserVO user, HttpSession session){
		String uiProfileImg = fileUtil.saveFile(user.getUiProfile(), "profile");
		user.setUiProfileImg(uiProfileImg);
		userMapper.updateUser(user);
		UserVO dbUser = userMapper.selectUserById(user.getUiId());
		session.setAttribute("user", dbUser);
		return user;
	}
	
	public int deleteUser(int uiNum) {
		return userMapper.deleteUser(uiNum);
	}
}
