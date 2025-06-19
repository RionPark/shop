package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.ProductReplyVO;

public interface ProductReplyMapper {
	List<ProductReplyVO> selectProductReplyList(ProductReplyVO productReply);
	ProductReplyVO selectProductReply(int priNum);
	int insertProductReply(ProductReplyVO productReply);
	int updateProductReply(ProductReplyVO productReply);
	int deleteProductReply(int priNum);
} 