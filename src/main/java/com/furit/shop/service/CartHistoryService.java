package com.furit.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furit.shop.mapper.CartHistoryMapper;
import com.furit.shop.vo.CartHistoryVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartHistoryService {
	private final CartHistoryMapper cartMapper;
	public List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cartHistory){
		return cartMapper.selectCartHistoryList(cartHistory);
	}
	public CartHistoryVO selectCartHistory(int chiNum){
		return cartMapper.selectCartHistory(chiNum);
	}
	public int insertCartHistory(CartHistoryVO cartHistory){ // uiNum : 4, piNum : 10
		int cnt = cartMapper.selectCartHisotryByUiNumAndPiNum(cartHistory);
		if(cartHistory.getChiQty()==0) {
			cartHistory.setChiQty(1);
		}
		if(cnt!=0) {
			return cartMapper.updateCartHistoryChiQty(cartHistory);
		}
		return cartMapper.insertCartHistory(cartHistory);
	}
	public int updateCartHistory(CartHistoryVO cartHistory){
		return cartMapper.updateCartHistory(cartHistory);
	}
	public int deleteCartHistory(int chiNum){
		return cartMapper.deleteCartHistory(chiNum);
	}
}
