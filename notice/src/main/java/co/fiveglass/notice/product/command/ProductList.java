package co.fiveglass.notice.product.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.product.service.ProductService;
import co.fiveglass.notice.product.service.ProductVO;
import co.fiveglass.notice.product.serviceImpl.ProductServiceImpl;

public class ProductList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ProductService ps = new ProductServiceImpl(); //모델 호출
		List<ProductVO> products = new ArrayList<>(); //결과 담을 것
		
		products = ps.productSelectList(); //값받아오기
		request.setAttribute("products", products); //jsp에 보내기 위해 결과 객체를 담는다
		
		return "product/productList";
	}

}
