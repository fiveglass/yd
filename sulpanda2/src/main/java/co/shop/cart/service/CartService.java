package co.shop.cart.service;

import java.util.List;



public interface CartService {
	
	List<CartVO> cartSelectList(CartVO vo);
	CartVO cartSelect(CartVO vo);
	int cartInsert(CartVO vo);
	int cartUpdate(CartVO vo);
	int cartMinus(CartVO vo);
	int cartPlus(CartVO vo);
	int cartDelete(CartVO vo);
	
	int orderSuccessDelete(String[] cartId); //결제완료 시 장바구니에서 삭제
	
	List<CartVO> paymentOrder(String[] cartId);
}
