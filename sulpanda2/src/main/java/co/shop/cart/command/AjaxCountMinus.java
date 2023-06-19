package co.shop.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;

public class AjaxCountMinus implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService cs = new CartServiceImpl();
		CartVO vo = new CartVO();
		vo.setCartId(Integer.valueOf(request.getParameter("id")));
		cs.cartMinus(vo);
		String str = "Ajax:a";
		return str;
	}

}
