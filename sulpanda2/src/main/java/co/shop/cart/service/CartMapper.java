package co.shop.cart.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface CartMapper {
	
	List<CartVO> cartSelectList(CartVO vo);
	CartVO cartSelect(CartVO vo);
	int cartInsert(CartVO vo);
	int cartUpdate(CartVO vo);
	int cartMinus(CartVO vo);
	int cartPlus(CartVO vo);
	int cartDelete(CartVO vo);
	
	int orderSuccessDelete(@Param("cartIdArray") String[] cartId); //결제완료 시 장바구니에서 삭제
	
	List<CartVO> paymentOrder(@Param("cartIdArray") String[] cartId);
}
