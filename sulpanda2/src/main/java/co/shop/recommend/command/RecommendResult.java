package co.shop.recommend.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;

public class RecommendResult implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println("option1 = " + request.getParameter("option1"));
		System.out.println("option2 = " + request.getParameter("option2"));
		System.out.println("option3 = " + request.getParameter("option3"));
		
		request.setAttribute("option1", request.getParameter("option1"));
		request.setAttribute("option2", request.getParameter("option2"));
		request.setAttribute("option3", request.getParameter("option3"));
		
//		List<ProductVO> productVoList = alisdjhflkajhs;
		
//		request.setAttribute("productList", productVoList);
				
				
		
		
		return "recommend/recommendResult";
	}

}
