package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furit.shop.service.ProductService;
import com.furit.shop.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewsController {
	private final ProductService productService;
	

	@GetMapping("/")
	public String home(Model m) {
		List<ProductVO> products = productService.selectProductList(null);
		m.addAttribute("products",products);
		return "index";
	}
	
	@GetMapping("/views/**")
	public void goPage( Model m) {
		m.addAttribute("text","The generated Lorem Ipsum is therefore always free from repetition injected humour, or non-characteristic words etc.\r\n"
				+ "\r\n"
				+ "Susp endisse ultricies nisi vel quam suscipit. Sabertooth peacock flounder; chain pickerel hatchetfish, pencilfish snailfish");
		
	}
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
}
