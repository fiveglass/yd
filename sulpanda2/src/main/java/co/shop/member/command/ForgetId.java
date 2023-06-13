package co.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;

public class ForgetId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/forgetId";
	}

}
