package co.shop.social.command;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;

public class NaverLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
	    String state = new BigInteger(64, random).toString();
		sb.append("https://nid.naver.com/oauth2.0/authorize");
		sb.append("?response_type=code");
		sb.append("&client_id=X9NAHBFGAzeE8b0LaUXS");
		sb.append("&redirect_uri=http://localhost/meddle/naverCallback.do");
		sb.append("&state=");
		sb.append(state);
		String url = sb.toString();
		
		return url;
	}

}
