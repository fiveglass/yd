package co.shop.recommend.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;

public class Recommend implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "recommend/recommend";
	}

}
