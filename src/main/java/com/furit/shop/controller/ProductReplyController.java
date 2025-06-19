package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.ProductReplyService;
import com.furit.shop.vo.ProductReplyVO;
import com.furit.shop.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
public class ProductReplyController {
	@Autowired
	private ProductReplyService ProductReplyService;
	
	@GetMapping("/product-replies")
	public List<ProductReplyVO> selectProductReplyList(ProductReplyVO productReply){
		return ProductReplyService.selectProductReplyList(productReply);
	}
	
	@GetMapping("/product-replies/{priNum}")
	public ProductReplyVO selectProductReply(@PathVariable("priNum") int priNum) {
		return ProductReplyService.selectProductReply(priNum);
	}
	
	@PostMapping("/product-replies")
	public int insertProductReply(@RequestBody ProductReplyVO productReply, HttpSession session) {
		UserVO user = (UserVO)session.getAttribute("user");
		productReply.setUiNum(user.getUiNum());
		return ProductReplyService.insertProductReply(productReply);
	}
	
	@PutMapping("/product-replies")
	public int updateProductReply(@RequestBody ProductReplyVO productReply) {
		return ProductReplyService.updateProductReply(productReply);
	}
	
	@DeleteMapping("/product-replies/{priNum}")
	public int deleteProductReply(@PathVariable("priNum") int priNum) {
		return ProductReplyService.deleteProductReply(priNum);
	}
} 