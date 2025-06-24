package com.furit.shop.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.furit.shop.service.ProductReplyService;
import com.furit.shop.service.ProductService;
import com.furit.shop.vo.ProductReplyVO;
import com.furit.shop.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ShopController {
/*
 * Controller(화면, ResponseBody) , RestController 차이점(ResponseBody)
 */
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductReplyService productReplyService;
	
	@GetMapping("/shop-detail")
	public String goShopDetail(Model m, @ModelAttribute ProductReplyVO productReply) {
		m.addAttribute("product",productService.selectProduct(productReply.getPiNum()));
		m.addAttribute("productReplys", productReplyService.selectProductReplyList(productReply));
		return "views/shop-detail";
	}
	
	public static void main(String[] args) {
		List<String> strs = Arrays.asList(new String[]{"1","2","3"});
		for(String str : strs) {
			
		}
	}
}
