package co.shop.payment.command;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;
import co.shop.kakaopay.service.KakaopayService;
import co.shop.kakaopay.service.KakaopayVO;
import co.shop.kakaopay.service.Impl.KakaopayServiceImpl;
import co.shop.orderproduct.service.OrderProductService;
import co.shop.orderproduct.service.OrderProductVO;
import co.shop.orderproduct.service.Impl.OrderProductServiceImpl;

public class DepositMessage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// order 테이블에 값 저장하기
		KakaopayService ks = new KakaopayServiceImpl();
		KakaopayVO kvo = new KakaopayVO();
		HttpSession session = request.getSession();
		
		String orderId = (String) request.getParameter("orderNo");
		String memberId = (String) session.getAttribute("id");
		int orderPrice = Integer.parseInt((String) request.getParameter("totalPrice"));
		String memberAddr = (String) request.getParameter("address");
		String memberTel = (String) request.getParameter("membertel");
		String deliveryMessage = (String) request.getParameter("deliveryMessage");
		
		kvo.setOrderId(orderId);
		kvo.setMemberId(memberId);
		kvo.setOrderPrice(orderPrice);
		kvo.setMemberAddr(URLDecoder.decode(memberAddr, StandardCharsets.UTF_8));
		kvo.setMemberTel(memberTel);
		kvo.setDeliveryMessage(URLDecoder.decode(deliveryMessage, StandardCharsets.UTF_8));
		
		int n = ks.depositInsert(kvo);
		
		//cartId로 db에서 cart 정보값 다 가지고오기
		CartService cs = new CartServiceImpl();
		List<CartVO> cartproducts = new ArrayList<>();
		String[] cartIdArray = ((String) request.getParameter("cartId")).split(",");
		cartproducts = cs.paymentOrder(cartIdArray);
		
		//cart 정보값 이용해서 order_product 값 저장하기
		OrderProductService os = new OrderProductServiceImpl();
		OrderProductVO ovo = new OrderProductVO();
		
		for(int i = 0; i<cartIdArray.length; i++) {
			ovo.setOrderId(orderId);
			ovo.setProductName(cartproducts.get(i).getProductName());
			ovo.setProductCount(cartproducts.get(i).getProductCount());
			ovo.setProductFee(cartproducts.get(i).getProductFee());
			
			int m = os.OrderProductInsert(ovo);
		}
		
		//성공적으로 저장되었으면 cartId는 삭제처리하기
		int deleteResult = cs.orderSuccessDelete(cartIdArray);
		
		//주문완료 페이지에 보일 값들 저장
		request.setAttribute("orderId", orderId);
		request.setAttribute("orderPrice", orderPrice);
		
		return "deposit/depositMessage";
	}

}
