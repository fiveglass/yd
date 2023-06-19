package co.shop.cart.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.shop.cart.service.CartMapper;
import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.common.DataSource;

public class CartServiceImpl implements CartService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CartMapper map = sqlSession.getMapper(CartMapper.class);
	
	
	@Override
	public List<CartVO> cartSelectList(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartSelectList(vo);
	}

	@Override
	public CartVO cartSelect(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartSelect(vo);
	}

	@Override
	public int cartInsert(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartInsert(vo);
	}

	@Override
	public int cartUpdate(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartUpdate(vo);
	}

	@Override
	public int cartDelete(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartDelete(vo);
	}

	@Override
	public int cartMinus(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartMinus(vo);
	}

	@Override
	public int cartPlus(CartVO vo) {
		// TODO Auto-generated method stub
		return map.cartPlus(vo);
	}

	@Override
	public List<CartVO> paymentOrder(String[] cartId) {
		// TODO Auto-generated method stub
		return map.paymentOrder(cartId);
	}

	@Override
	public int orderSuccessDelete(String[] cartId) {
		// TODO Auto-generated method stub
		return map.orderSuccessDelete(cartId);
	}

}
