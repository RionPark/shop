package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.furit.shop.service.CategoryService;
import com.furit.shop.service.ProductReplyService;
import com.furit.shop.service.ProductService;
import com.furit.shop.vo.CategoryVO;
import com.furit.shop.vo.ProductReplyVO;

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
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/shop-detail")
	public String goShopDetail(Model m, @ModelAttribute ProductReplyVO productReply) {
		m.addAttribute("product",productService.selectProduct(productReply.getPiNum()));
		m.addAttribute("productReplys", productReplyService.selectProductReplyList(productReply));
		m.addAttribute("categories", categoryService.selectCategoryList(null));
		return "views/shop-detail";
	}
	
	@GetMapping("/shops")
	public String goShop(Model m) {
		m.addAttribute("products",productService.selectProductList(null));
		m.addAttribute("categories", categoryService.selectCategoryList(null));
		return "views/shop";
	}
	
}
