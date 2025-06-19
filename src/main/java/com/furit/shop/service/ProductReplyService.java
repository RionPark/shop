package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.ProductReplyMapper;
import com.furit.shop.vo.ProductReplyVO;

@Service
public class ProductReplyService {

	@Autowired
	private ProductReplyMapper ProductReplyMapper;
	
	public List<ProductReplyVO> selectProductReplyList(ProductReplyVO productReply){
		return ProductReplyMapper.selectProductReplyList(productReply);
	}
	
	public ProductReplyVO selectProductReply(int priNum) {
		return ProductReplyMapper.selectProductReply(priNum);
	}
	
	public int insertProductReply(ProductReplyVO productReply) {
		return ProductReplyMapper.insertProductReply(productReply);
	}
	
	public int updateProductReply(ProductReplyVO productReply) {
		return ProductReplyMapper.updateProductReply(productReply);
	}
	
	public int deleteProductReply(int priNum) {
		return ProductReplyMapper.deleteProductReply(priNum);
	}
} 