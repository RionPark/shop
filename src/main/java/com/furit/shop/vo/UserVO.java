package com.furit.shop.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private int uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String uiProfileImg;
	private MultipartFile uiProfile;
	private String cretim;
	private String credat;
	private String lmodat;
	private String lmotim;
}
