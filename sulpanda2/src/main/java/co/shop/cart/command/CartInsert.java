package co.shop.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;

public class CartInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService cs = new CartServiceImpl();
		CartVO vo = new CartVO();
		HttpSession session = request.getSession();
		vo.setMemberId(String.valueOf(session.getAttribute("id")));
		vo.setProductCount(Integer.valueOf(request.getParameter("productCount")));
		vo.setProductFee(Integer.valueOf(request.getParameter("productFee")));
		vo.setProductId(request.getParameter("productId"));
		vo.setProductName(request.getParameter("productName"));
		
		CartVO voo = new CartVO();
		voo = cs.cartSelect(vo);
		if(voo != null) {
			voo.setProductCount(vo.getProductCount());
			int i = cs.cartUpdate(voo);
		} else {
			cs.cartInsert(vo);			
		}
		return "cartList.do";
	}

}
