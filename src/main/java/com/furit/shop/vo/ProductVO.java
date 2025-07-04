package com.furit.shop.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int pageNum;
	private int rowNum;
	private int piNum;
	private int priRate;
	private String piName;
	private String piDesc;
	private int piPrice; // ==
	private int piPriceRange; // <=
	private String piUnit;
	private String piImgPath;
	private MultipartFile piImg;
	private String piDesc2;
	private Integer ciNum;
	private String ciName;
	private String ciDesc;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String searchStr;
	private String sort;
}
