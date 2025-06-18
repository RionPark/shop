package com.furit.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.CartHistoryService;
import com.furit.shop.vo.CartHistoryVO;
import com.furit.shop.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartHistoryController {
	private final CartHistoryService cartService;
	
	@GetMapping("/carts")
	public List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cartHistory){
		return cartService.selectCartHistoryList(cartHistory);
	}
	@GetMapping("/carts/{chiNum}")
	public CartHistoryVO selectCartHistory(@PathVariable("chiNum") int chiNum){
		return cartService.selectCartHistory(chiNum);
	}
	@PostMapping("/carts")
	public int insertCartHistory(@RequestBody CartHistoryVO cartHistory, HttpSession session){
		UserVO user = (UserVO)session.getAttribute("user");
		cartHistory.setUiNum(user.getUiNum());
		return cartService.insertCartHistory(cartHistory);
	}
	@PutMapping("/carts")
	public int updateCartHistory(CartHistoryVO cartHistory){
		return cartService.updateCartHistory(cartHistory);
	}
	@DeleteMapping("/carts")
	public int deleteCartHistory(int chiNum){
		return cartService.deleteCartHistory(chiNum);
	}
}
