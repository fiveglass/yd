package co.shop.kakaopay.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;

public class KakaopayMessage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String orderNo = request.getParameter("orderNo");
		String status = request.getParameter("status");
		
		request.setAttribute("status", status);
		request.setAttribute("orderNo", orderNo);
		
		return "kakaopay/kakaoMessage";
	}

}
