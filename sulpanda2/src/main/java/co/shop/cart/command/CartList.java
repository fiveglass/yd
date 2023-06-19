package co.shop.cart.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;

public class CartList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService cs = new CartServiceImpl();
		CartVO vo = new CartVO();
		HttpSession session = request.getSession();
		vo.setMemberId(String.valueOf(session.getAttribute("id")));
		List<CartVO> carts = cs.cartSelectList(vo);

		
		request.setAttribute("carts", carts);
		
		return "cart/cartList";
	}

}
