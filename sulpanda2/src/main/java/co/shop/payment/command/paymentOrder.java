package co.shop.payment.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;

public class paymentOrder implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		CartService cs = new CartServiceImpl();
		List<CartVO> cartproducts = new ArrayList<>();
		String[] cartIdArray = request.getParameter("cartId").split(",");
		cartproducts = cs.paymentOrder(cartIdArray);
		request.setAttribute("cartproducts", cartproducts);
		request.setAttribute("cartId", request.getParameter("cartId"));
		
		
		return "payment/paymentOrder";
	}

}
