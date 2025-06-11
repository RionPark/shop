package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> selectProductList(ProductVO Product);
	int insertProduct(ProductVO Product);
	int updateProduct(ProductVO Product);
	int deleteProduct(int ciNum);
}	
