package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.UserVO;

public interface UserMapper {
	List<UserVO> selectUserList(UserVO user);
	UserVO selectUser(int uiNum);
	UserVO selectUserById(String uiId);
	int insertUser(UserVO user);
	int updateUser(UserVO user);
	int deleteUser(int uiNum);
}
