package com.furit.shop.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Utils {
	private static final String SALT = "sadf-afs-sa-sadflxzvkljfsdalkjwlkejrklj";

	public static String encodePwd(String uiPwd) {
		return DigestUtils.sha256Hex(uiPwd + SALT);
	}
	
	public static void main(String[] args) {
		String uiPwd = "1234";
		String encodePwd = DigestUtils.sha256Hex(uiPwd + SALT); //복호화 안됨
		// 모든 암호과 동일하게 일어남.
		System.out.println(encodePwd);
		
	}
}
