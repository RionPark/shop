package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.CartHistoryVO;

public interface CartHistoryMapper {
	List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cartHistory);
	CartHistoryVO selectCartHistory(int chiNum); 
	int selectCartHisotryByUiNumAndPiNum(CartHistoryVO cartHistory);
	int insertCartHistory(CartHistoryVO cartHistory); 
	int updateCartHistory(CartHistoryVO cartHistory); 
	int updateCartHistoryChiQty(CartHistoryVO cartHistory); 
	int deleteCartHistory(int chiNum); 
}
