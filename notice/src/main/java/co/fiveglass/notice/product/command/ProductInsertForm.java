package co.fiveglass.notice.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;

public class ProductInsertForm implements Command {
	//jsp form으로 보내어서 insert할 값 받는 역할
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "product/productInsert";
	}

}
